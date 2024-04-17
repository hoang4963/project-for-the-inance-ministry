package com.its.xoso.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "xs_vendors")
@Setter
@Getter
public class XSVendor extends XSBaseEntity {

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name = "revoked", columnDefinition = "TINYINT")
    private int revoked;

    private String description;
}

