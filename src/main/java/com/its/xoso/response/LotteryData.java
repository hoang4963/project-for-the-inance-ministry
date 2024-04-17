package com.its.xoso.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class LotteryData {

    @JsonProperty("success")
    private boolean success;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("code")
    private int code;
    @JsonProperty("t")
    private Ticket ticket;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Ticket {
        @JsonProperty("turnNum")
        private String turnNum;

        @JsonProperty("openTime")
        private String openTime;

        @JsonProperty("serverTime")
        private String serverTime;

        @JsonProperty("name")
        private String name;

        @JsonProperty("code")
        private String code;

        @JsonProperty("sort")
        private double sort;

        @JsonProperty("navCate")
        private String navCate;

        @JsonProperty("issueList")
        private List<Issue> issueList;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Issue {
        private String turnNum;
        private String openNum;
        private String openTime;
        private long openTimeStamp;
        private String[] detail;

        @JsonSetter("detail") // Sử dụng JsonSetter để chỉ định cách chuyển đổi
        public void setDetail(String detailString) {
            this.detail = detailString.replaceAll("[\\[\\]\"]", "").split(",");
        }

        private int status;
        private String replayUrl;
        private String n11;
        private int jackpot;
    }
}