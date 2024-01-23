package com.its.karaoke.controller;


import com.its.karaoke.aop.KaraSpecialLog;
import com.its.karaoke.facade.KaraLoginFacade;
import com.its.karaoke.request.KaraLoginRequest;
import com.its.karaoke.response.KaraEContractDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api/v1")
public class KaraLoginController {

    @Autowired
    private KaraLoginFacade facade;

    @KaraSpecialLog
    @PostMapping("vendor/login")
    public ResponseEntity login(@RequestBody @Valid KaraLoginRequest loginRequest) {
        Map<String, Object> result = facade.login(loginRequest);
        return KaraEContractDto.build().withSuccess(true).withData(result).toResponseEntity();
    }
}
