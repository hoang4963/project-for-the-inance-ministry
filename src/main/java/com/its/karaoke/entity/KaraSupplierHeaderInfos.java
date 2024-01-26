package com.its.karaoke.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kara_supplier_header_infos")
@Getter
@Setter
public class KaraSupplierHeaderInfos extends KaraBaseEntity{
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "header_code")
    private String headerCode;
}
