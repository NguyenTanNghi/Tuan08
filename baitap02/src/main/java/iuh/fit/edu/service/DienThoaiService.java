package iuh.fit.edu.service;

import iuh.fit.edu.entity.DienThoai;
import iuh.fit.edu.entity.NhaCungCap;
import iuh.fit.edu.repository.DienThoaiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DienThoaiService {
    private final DienThoaiRepository repo;

    public DienThoaiService(DienThoaiRepository repo) {
        this.repo = repo;
    }

    public List<DienThoai> findAll() { return repo.findAll(); }

    public List<DienThoai> findByNcc(NhaCungCap ncc) { return repo.findByNhaCungCap(ncc); }

    public DienThoai getById(String maDt) { return repo.findById(maDt).orElse(null); }

    public DienThoai save(DienThoai dt) { return repo.save(dt); }

    public void delete(String maDt) { repo.deleteById(maDt); }
}
