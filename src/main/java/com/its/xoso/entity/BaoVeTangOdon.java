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
@Table(name = "BaoVeTangOdon")
public class BaoVeTangOdon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "danh_muc")
    private Integer danhMuc;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;

    @Column(name = "ket_qua", columnDefinition = "TEXT")
    private String ketQua;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;

    @Column(name = "linh_vuc")
    private Integer linhVuc;


    @Column(name = "chat_suy_giam", columnDefinition = "TEXT")
    private String chatSuyGiam;

    @Column(name = "hoat_dong", columnDefinition = "TEXT")
    private String hoatDong;

    @Column(name = "tan_suat", columnDefinition = "TEXT")
    private String tanSuat;

    @Column(name = "quy_mo", columnDefinition = "TEXT")
    private String quyMo;

    @Column(name = "duoc_ghi_nhan", columnDefinition = "TEXT")
    private String duocGhiNhan;


    @Column(name = "dia_diem", columnDefinition = "TEXT")
    private String diaDiem;

    @Column(name = "kha_nang_anh_huong", columnDefinition = "TEXT")
    private String khaNangAnhHuong;

    @Column(name = "bien_phap", columnDefinition = "TEXT")
    private String bien_phap;

    @Column(name = "da_ap_dung_chua", columnDefinition = "TEXT")
    private String daApDungChua;

}
