package com.its.xoso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "KichBanBDKH")
public class KichBanBDKH {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "nam_du_bao")
    private Integer namDuBao;

    @Column(name = "chi_so")
    private String chiSo;

    @Column(name = "gia_tri")
    private Float giaTri;

    @Column(name = "don_vi")
    private String donVi;

    @Column(name = "ghi_chu")
    private String ghiChu;
}

