package com.its.karaoke.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kara_supplier")
@Getter
@Setter
public class KaraSupplier extends KaraBaseEntity{

    @Column(name = "cp_code")
    private String cpCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
