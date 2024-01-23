package com.its.karaoke.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "kara_sing_info")
@Setter
@Getter
public class KaraSingInfo extends KaraBaseEntity {
    @Column(name = "request_id")
    private String requestId;

    @Column(name = "cp_code")
    private String cpCode;

    @Column(name = "header_code")
    private String headerCode;

    @Column(name = "code_song")
    private String codeSong;

    @Column(name = "author")
    private String author;

    @Column(name = "singer")
    private String singer;

    @Column(name = "event")
    private int event;

    @Column(name = "time")
    private Timestamp time;

}
