package iuh.fit.edu.repository;

import iuh.fit.edu.entity.DienThoai;
import iuh.fit.edu.entity.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, String> {
    List<DienThoai> findByNhaCungCap(NhaCungCap ncc);
}
