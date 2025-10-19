package iuh.fit.edu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "NHACUNGCAP")
public class NhaCungCap {

    @Id
    @Column(name = "MANCC", length = 20)
    @NotBlank(message = "Mã NCC bắt buộc")
    private String maNcc;

    @Column(name = "TENNHACC", nullable = false, length = 100)
    @NotBlank(message = "Tên NCC bắt buộc")
    private String tenNhaCc;

    @Column(name = "DIACHI", length = 255)
    @NotBlank(message = "Địa chỉ bắt buộc")
    private String diaChi;

    @Column(name = "SODIENTHOAI", length = 20)
    @NotBlank(message = "Số điện thoại bắt buộc")
    @Pattern(regexp = "^[0-9]{9,11}$", message = "Số điện thoại 9–11 chữ số")
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<DienThoai> dienThoais;
}
