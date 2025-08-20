package com.its.xoso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "VanBanPhapLuat")
public
class VanBanPhapLuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_hieu")
    private String soHieu;

    @Column(name = "loai_van_ban")
    private String loaiVanBan;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "nam_ban_hanh")
    private Integer namBanHanh;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "co_quan_ban_hanh")
    private String coQuanBanHanh;

    @Column(name = "don_vi_cung_cap")
    private String donViCungCap;

    @Column(name = "pham_vi_du_lieu", columnDefinition = "TEXT")
    private String phamViDuLieu;

    @Column(name = "thong_tin_trien_khai")
    private String thongTinTrienKhai;

    @Column(name = "thich_ung_giam_nhe")
    private String thichUngGiamNhe;

    @Column(name = "ket_qua")
    private String ketQua;

    @Column(name = "ton_tai")
    private String tonTai;
}