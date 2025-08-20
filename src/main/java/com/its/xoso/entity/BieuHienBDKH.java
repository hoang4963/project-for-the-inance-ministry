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
@Table(name = "BieuHienBDKH")
public
class BieuHienBDKH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "loai_hinh")
    private Integer loaiHinh;

    @Column(name = "bieu_hien", columnDefinition = "TEXT")
    private String bieuHien;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "thoi_gian", columnDefinition = "TEXT")
    private String thoiGian;

    @Column(name = "dia_diem", columnDefinition = "TEXT")
    private String diaDiem;

    @Column(name = "tan_xuat")
    private String tanXuat;

    @Column(name = "quy_mo", columnDefinition = "TEXT")
    private String quyMo;
}
