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
@Table(name = "TieuChi")
public class TieuChi {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "danh_muc")
    private Integer danhMuc;

    @Column(name = "noi_dung", columnDefinition = "TEXT")
    private String noiDung;
}
