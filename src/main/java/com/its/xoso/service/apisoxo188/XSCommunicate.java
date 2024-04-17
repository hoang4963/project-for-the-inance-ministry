package com.its.xoso.service.apisoxo188;

import com.its.xoso.response.LotteryData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface XSCommunicate {
    @GET("api/front/open/lottery/history/list/{number}/miba")
    Call<LotteryData> getLotteryNorth(
            @Path("number") int number
    );

    @GET("api/front/open/lottery/history/list/{number}/vnmbmg")
    Call<LotteryData> getLotteryVIPSouth75(
            @Path("number") int number
    );

    @GET("/{number}/vnmtmg")
    Call<LotteryData> getLotteryVipMid75(
            @Path("number") int number
    );

    @GET("/{number}/vnmnmg")
    Call<LotteryData> getLotteryNorth45(
            @Path("number") int number
    );

    @GET("/{number}/platmg1p")
    Call<LotteryData> getLotteryVietlot(
            @Path("number") int number
    );

    @GET("/{number}/st45g")
    Call<LotteryData> getLotteryFast(
            @Path("number") int number
    );

    @GET("/{number}/vnst45g")
    Call<LotteryData> getLotteryVipFast(
            @Path("number") int number
    );
}

