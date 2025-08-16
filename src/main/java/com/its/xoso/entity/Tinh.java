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
@Table(name = "Tinh")
public
class Tinh {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma_tinh")
    private String matinh;

    @Column(name = "ten_tinh")
    private String tenTinh;

    @Column(name = "kinh_do")
    private float kinhDo;

    @Column(name = "vi_do")
    private float viDo;
}
