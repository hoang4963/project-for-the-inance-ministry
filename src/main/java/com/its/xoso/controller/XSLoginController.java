package com.its.xoso.controller;


import com.its.xoso.aop.XSSpecialLog;
import com.its.xoso.facade.XSLoginFacade;
import com.its.xoso.request.XSLoginRequest;
import com.its.xoso.response.XSResponseDto;
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
public class XSLoginController {

    @Autowired
    private XSLoginFacade facade;

    @XSSpecialLog
    @PostMapping("vendor/login")
    public ResponseEntity login(@RequestBody @Valid XSLoginRequest loginRequest) {
        Map<String, Object> result = facade.login(loginRequest);
        return XSResponseDto.build().withSuccess(true).withData(result).toResponseEntity();
    }
}
