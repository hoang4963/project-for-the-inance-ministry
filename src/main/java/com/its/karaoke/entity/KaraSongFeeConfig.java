package com.its.karaoke.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kara_song_fee_config")
@Setter
@Getter
public class KaraSongFeeConfig extends KaraBaseEntity{

    @Column(name = "song_code")
    private String songCode;

    @Column(name = "from_min")
    private Long fromMin;

    @Column(name = "to_min")
    private Long toMin;

    @Column(name = "fee_per_min")
    private int feePerMin;

    @Column(name = "status")
    private Integer status;

    @Column(name = "priority")
    private Integer priority;

}
