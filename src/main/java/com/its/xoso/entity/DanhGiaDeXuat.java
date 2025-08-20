package com.its.xoso.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DanhGiaDeXuat")
public class DanhGiaDeXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;

    @Column(name = "de_xuat", columnDefinition = "TEXT")
    private String deXuat;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "ton_tai", columnDefinition = "TEXT")
    private String tonTai;

    @Column(name = "han_che", columnDefinition = "TEXT")
    private String hanChe;

    @Column(name = "kho_khan", columnDefinition = "TEXT")
    private String khoKhan;

    @Column(name = "giai_phap", columnDefinition = "TEXT")
    private String giaiPhap;

    @Column(name = "hien_trang_CSDL", columnDefinition = "TEXT")
    private String hienTrang;
}
