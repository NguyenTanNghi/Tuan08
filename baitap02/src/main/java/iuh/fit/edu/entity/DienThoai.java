package iuh.fit.edu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "DIENTHOAI")
public class DienThoai {

    @Id
    @Column(name = "MADT", length = 20)
    @NotBlank(message = "Mã ĐT bắt buộc")
    private String maDt;

    @Column(name = "TENDT", nullable = false, length = 150)
    @NotBlank(message = "Tên điện thoại bắt buộc")
    private String tenDt;

    @Column(name = "NAMSANXUAT")
    @NotNull(message = "Năm sản xuất bắt buộc")
    @Min(value = 1900, message = "Năm không hợp lệ")
    @Max(value = 2100, message = "Năm không hợp lệ")
    private Integer namSanXuat;

    @Column(name = "CAUHINH", length = 255)
    @NotBlank(message = "Cấu hình bắt buộc")
    @Size(max = 255, message = "Cấu hình tối đa 255 ký tự")
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "MANCC", nullable = false)
    @NotNull(message = "Phải chọn nhà cung cấp")
    private NhaCungCap nhaCungCap;

    @Column(name = "HINHANH", length = 255)
    private String hinhAnh; // lưu tên file (đường dẫn hiển thị: /uploads/{hinhAnh})
}
