package com.its.xoso.service.apisoxo188;

import com.its.xoso.communication.RetrofitAbstractCommunication;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class XSClient extends RetrofitAbstractCommunication {

    protected XSCommunicate XSCommunicate;

    @Value(value = "${XS.188}")
    String baseUrl;

    @PostConstruct
    public void init() {
        XSCommunicate = buildSetting(baseUrl);
    }


    protected XSCommunicate buildSetting(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(this.buildCommunication())
                .build();

        return retrofit.create(XSCommunicate.class);
    }
}

