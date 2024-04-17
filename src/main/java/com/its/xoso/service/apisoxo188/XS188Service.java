package com.its.xoso.service.apisoxo188;

import com.its.xoso.response.LotteryData;
import com.its.xoso.utils.XSDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Objects;


@Component
public class XS188Service extends XSClient {

    public LotteryData callXS188() {
        long begin = XSDateUtils.currentTimeMillis();
        Response<LotteryData> response;
        LotteryData dto = null;
        try {
            Call<LotteryData> request = XSCommunicate.getLotteryNorth(5);
            response = request.execute();
            if (response.isSuccessful()) {
                dto = response.body();
                Objects.requireNonNull(dto, "Process get XS 188. Response body null");

            } else {
                System.out.println("res is falied");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            long end = XSDateUtils.currentTimeMillis();
            System.out.println("End get XS 188 data end = {} execution = {}");
        }
        return dto;
    }
}
