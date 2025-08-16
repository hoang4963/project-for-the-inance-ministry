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
@Table(name = "NghienCuuKHCN")
public class NghienCuuKHCN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tinh")
    private Integer tinh;

    @Column(name = "nam")
    private Integer nam;

    @Column(name = "ten_de_tai")
    private String tenDeTai;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    private String moTa;

    @Column(name = "ket_qua", columnDefinition = "TEXT")
    private String ketQua;

    @Column(name = "don_vi_chu_tri")
    private String donViChuTri;

    @Column(name = "don_vi_bao_cao")
    private Integer donViBaoCao;

    @Column(name = "linh_vuc")
    private Integer linhVuc;
}
