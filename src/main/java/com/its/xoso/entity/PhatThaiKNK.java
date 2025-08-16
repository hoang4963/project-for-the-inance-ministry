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
@Table(name = "PhatThaiKNK")
public
class PhatThaiKNK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "nguon_tac_dong")
    private String nguonTacDong;

    @Column(name = "mo_ta_hoat_dong", columnDefinition = "TEXT")
    private String moTaHoatDong;

    @Column(name = "mo_ta_bien_dong", columnDefinition = "TEXT")
    private String moTaBienDong;

    @Column(name = "phan_tram_ch4")
    private Float phanTramCh4;

    @Column(name = "mo_ta_ch4", columnDefinition = "TEXT")
    private String moTaCh4;

    @Column(name = "phan_tram_n2o")
    private Float phanTramN2o;

    @Column(name = "mo_ta_n2o", columnDefinition = "TEXT")
    private String moTaN2o;

    @Column(name = "phan_tram_co2")
    private Float phanTramCo2;

    @Column(name = "mo_ta_co2", columnDefinition = "TEXT")
    private String moTaCo2;

    @Column(name = "dia_diem")
    private String diaDiem;

    @Column(name = "dien_tich")
    private Float dienTich;

    @Column(name = "thoi_gian")
    private String thoiGian;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;
}