package iuh.fit.edu.controller;

import iuh.fit.edu.entity.DienThoai;
import iuh.fit.edu.entity.NhaCungCap;
import iuh.fit.edu.service.DienThoaiService;
import iuh.fit.edu.service.FileStorageService;
import iuh.fit.edu.service.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/dt")
public class DienThoaiController {

    private final DienThoaiService dtService;
    private final NhaCungCapService nccService;
    private final FileStorageService storageService;

    public DienThoaiController(DienThoaiService dtService, NhaCungCapService nccService, FileStorageService storageService) {
        this.dtService = dtService;
        this.nccService = nccService;
        this.storageService = storageService;
    }

    // Liệt kê điện thoại theo NCC
    @GetMapping("/ncc/{maNcc}")
    public String listByNcc(@PathVariable String maNcc, Model model) {
        NhaCungCap ncc = nccService.getById(maNcc);
        if (ncc == null) {
            model.addAttribute("message", "Không tìm thấy nhà cung cấp: " + maNcc);
            return "message";
        }
        model.addAttribute("ncc", ncc);
        model.addAttribute("dsDienThoai", dtService.findByNcc(ncc));
        return "dt-list-by-ncc";
    }

    // Form thêm mới
    @GetMapping("/add")
    public String addForm(@RequestParam(value = "maNcc", required = false) String maNcc, Model model) {
        DienThoai dt = new DienThoai();
        if (maNcc != null) {
            NhaCungCap ncc = nccService.getById(maNcc);
            dt.setNhaCungCap(ncc);
        }
        model.addAttribute("dt", dt);
        model.addAttribute("nccList", nccService.findAll());
        return "dt-form";
    }

    // Lưu (kèm upload ảnh)
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("dt") DienThoai dt,
                       BindingResult result,
                       @RequestParam("imageFile") MultipartFile imageFile,
                       Model model) {
        if (result.hasErrors()) {
            model.addAttribute("nccList", nccService.findAll());
            return "dt-form";
        }

        // Validate client-side đã có; đây server-side chặn wrong ext:
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                String filename = storageService.saveImage(imageFile);
                dt.setHinhAnh(filename);
            }
        } catch (IOException e) {
            result.rejectValue("hinhAnh", "invalid.image", "Ảnh không hợp lệ (chỉ PNG/JPG/JPEG) hoặc lỗi lưu file.");
            model.addAttribute("nccList", nccService.findAll());
            return "dt-form";
        }

        dtService.save(dt);
        return "redirect:/dt/ncc/" + dt.getNhaCungCap().getMaNcc();
    }

    // Xoá điện thoại
    @GetMapping("/delete/{maDt}")
    public String delete(@PathVariable String maDt, Model model) {
        var dt = dtService.getById(maDt);
        if (dt == null) {
            model.addAttribute("message", "Không tìm thấy điện thoại: " + maDt);
            return "message";
        }
        storageService.deleteIfExists(dt.getHinhAnh());
        String maNcc = dt.getNhaCungCap().getMaNcc();
        dtService.delete(maDt);
        return "redirect:/dt/ncc/" + maNcc;
    }
}
