package iuh.fit.edu.repository;

import iuh.fit.edu.entity.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {
    List<NhaCungCap> findByMaNccContainingIgnoreCaseOrTenNhaCcContainingIgnoreCaseOrDiaChiContainingIgnoreCaseOrSoDienThoaiContaining(String a, String b, String c, String d);
}
