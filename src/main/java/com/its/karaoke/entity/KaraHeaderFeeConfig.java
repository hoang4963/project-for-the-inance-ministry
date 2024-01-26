package com.its.karaoke.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "kara_header_fee_config")
@Getter
@Setter
public class KaraHeaderFeeConfig extends KaraBaseEntity{

    @Column(name = "header_code")
    private String headerCode;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "using_fee")
    private int usingFee;
}
