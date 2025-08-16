package com.its.xoso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BienPhapThichUng")
public class BienPhapThichUng {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "loai_bien_phap")
    private String loaiBienPhap;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "pham_vi_ap_dung")
    private String phamViApDung;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "hieu_qua")
    private String hieuQua;
}

