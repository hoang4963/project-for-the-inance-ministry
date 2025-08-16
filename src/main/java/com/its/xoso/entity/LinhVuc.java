package com.its.xoso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LinhVuc")
public
class LinhVuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten")
    private String ten;
}


