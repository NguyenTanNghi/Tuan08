package iuh.fit.edu.controller;

import iuh.fit.edu.dto.SearchForm;
import iuh.fit.edu.entity.NhaCungCap;
import iuh.fit.edu.service.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ncc")
public class NhaCungCapController {

    private final NhaCungCapService nccService;

    public NhaCungCapController(NhaCungCapService nccService) {
        this.nccService = nccService;
    }

    // Trang danh sách + tìm kiếm NCC
    @GetMapping
    public String list(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        var list = nccService.search(searchForm.getKeyword());
        model.addAttribute("nccList", list);
        return "ncc-list";
    }

    // (Tuỳ chọn) Thêm NCC (nếu muốn nhập mẫu)
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("ncc", new NhaCungCap());
        return "ncc-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("ncc") NhaCungCap ncc, BindingResult result) {
        if (result.hasErrors()) return "ncc-form";
        nccService.save(ncc);
        return "redirect:/ncc";
    }
}
