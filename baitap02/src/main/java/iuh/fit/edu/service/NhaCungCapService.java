package iuh.fit.edu.service;

import iuh.fit.edu.entity.NhaCungCap;
import iuh.fit.edu.repository.NhaCungCapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungCapService {
    private final NhaCungCapRepository repo;

    public NhaCungCapService(NhaCungCapRepository repo) {
        this.repo = repo;
    }

    public List<NhaCungCap> findAll() {
        return repo.findAll();
    }

    public List<NhaCungCap> search(String keyword) {
        if (keyword == null || keyword.isBlank()) return findAll();
        return repo.findByMaNccContainingIgnoreCaseOrTenNhaCcContainingIgnoreCaseOrDiaChiContainingIgnoreCaseOrSoDienThoaiContaining(
                keyword, keyword, keyword, keyword);
    }

    public NhaCungCap getById(String maNcc) {
        return repo.findById(maNcc).orElse(null);
    }

    public NhaCungCap save(NhaCungCap ncc) {
        return repo.save(ncc);
    }
}
