package com.its.xoso.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LotteryData {
    private String turnNum;
    private String openTime;
    private String serverTime;
    private String name;
    private String code;
    private int sort;
    private String navCate;
    private List<Issue> issueList;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Issue {
        private String turnNum;
        private String openNum;
        private String openTime;
        private long openTimeStamp;
        private List<String> detail;
        private int status;
        private String replayUrl;
        private String n11;
        private int jackpot;


    }
}




