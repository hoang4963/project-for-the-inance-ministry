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
@Table(name = "HopTacQuocTe")
public class HopTacQuocTe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tinh")
    private Integer tinh;

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

    @Column(name = "tieu_chi")
    private Integer tieuChi;
}