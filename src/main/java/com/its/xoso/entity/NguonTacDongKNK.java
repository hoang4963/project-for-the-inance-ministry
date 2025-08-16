package com.its.xoso.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "NguonTacDongKNK")
public
class NguonTacDongKNK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "linh_vuc")
    private Integer linhVuc;

    @Column(name = "nguon_tac_dong")
    private String nguonTacDong;

    @Column(name = "co_che_phat_sinh")
    private String coChePhatSinh;

    @Column(name = "phat_thai_hap_thu")
    private Boolean phatThaiHapThu;

    @Column(name = "active")
    private Boolean active;
}
