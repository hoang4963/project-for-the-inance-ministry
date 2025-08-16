package com.its.xoso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TacDongBDKH")
public
class TacDongBDKH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "loai_hinh")
    private Integer loaiHinh;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "doi_tuong_nhom")
    private String doiTuongNhom;

    @Column(name = "phan_tram1")
    private Float phanTram1;

    @Column(name = "mo_ta1", columnDefinition = "TEXT")
    private String moTa1;

    @Column(name = "phan_tram2")
    private Float phanTram2;

    @Column(name = "mo_ta2", columnDefinition = "TEXT")
    private String moTa2;

    @Column(name = "phan_tram3")
    private Float phanTram3;

    @Column(name = "mo_ta3", columnDefinition = "TEXT")
    private String moTa3;

    @Column(name = "phan_tram4")
    private Float phanTram4;

    @Column(name = "mo_ta4", columnDefinition = "TEXT")
    private String moTa4;

    @Column(name = "mo_ta_hien_tuong", columnDefinition = "TEXT")
    private String moTaHienTuong;

    @Column(name = "pham_vi_anh_huong", columnDefinition = "TEXT")
    private String phamViAnhHuong;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;
}