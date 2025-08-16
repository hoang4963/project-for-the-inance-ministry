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
@Table(name = "GiamNheThichUng")
public
class GiamNheThichUng {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "danh_muc")
    private Integer danhMuc;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "ten_giai_phap")
    private String tenGiaiPhap;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "hieu_qua", columnDefinition = "TEXT")
    private String hieuQua;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;

    @Column(name = "loai_hinh")
    private Integer loaiHinh;

}
