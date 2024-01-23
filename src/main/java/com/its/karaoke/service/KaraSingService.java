package com.its.karaoke.service;


import com.its.karaoke.entity.KaraSingInfo;
import com.its.karaoke.request.KaraPushSingRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Log4j2
@Service
public class KaraSingService {

    public KaraSingInfo createKaraSingInfo(KaraPushSingRequest request, Timestamp time) {
        KaraSingInfo karaSingInfo = new KaraSingInfo();
        karaSingInfo.setRequestId(request.getRequestId());
        karaSingInfo.setCpCode(request.getCpCode());
        karaSingInfo.setHeaderCode(request.getHeaderCode());
        karaSingInfo.setCodeSong(request.getCodeSong());
        karaSingInfo.setAuthor(request.getAuthor());
        karaSingInfo.setSinger(request.getSinger());
        karaSingInfo.setEvent(request.getEvent());
        karaSingInfo.setTime(time);
        return karaSingInfo;
    }
}
