package com.its.karaoke.controller;


import com.its.karaoke.aop.KaraSpecialLog;
import com.its.karaoke.facade.KaraFacade;
import com.its.karaoke.request.KaraPushSingRequest;
import com.its.karaoke.response.KaraEContractDto;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/api/v1")
public class KaraokeController {

    @Autowired
    private KaraFacade facade;


    @KaraSpecialLog
    @PostMapping("/vendor/push_sing")
    public ResponseEntity pushSing(@RequestBody @Valid KaraPushSingRequest request) {
        boolean result = facade.pushSing(request);
        if (result)
            return KaraEContractDto.build()
                    .withStatus(HttpStatus.OK.value())
                    .withMessage("OK")
                    .withSuccess(true)
                    .toResponseEntity();
        return KaraEContractDto.build()
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withSuccess(false)
                .withMessage("BAD_REQUEST")
                .toResponseEntity();
    }

}
