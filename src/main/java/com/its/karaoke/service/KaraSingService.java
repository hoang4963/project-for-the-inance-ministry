package com.its.karaoke.service;


import com.its.karaoke.entity.KaraHeaderFeeConfig;
import com.its.karaoke.entity.KaraSingInfo;
import com.its.karaoke.entity.KaraSongFeeConfig;
import com.its.karaoke.exceptions.KaraBusinessException;
import com.its.karaoke.repository.KaraHeaderFeeConfigRepository;
import com.its.karaoke.repository.KaraSingInfoRepository;
import com.its.karaoke.repository.KaraSongFeeConfigRepository;
import com.its.karaoke.request.KaraPushSingRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private KaraSingInfoRepository singInfoRepository;

    @Autowired
    private KaraHeaderFeeConfigRepository headerFeeConfigRepository;

    @Autowired
    private KaraSongFeeConfigRepository songFeeConfigRepository;

    public long calculateSingFee(String requestId) {
        Optional<KaraSingInfo> karaOp = singInfoRepository.getSingInfoByRequestId(requestId);
        if (!karaOp.isPresent()) throw new KaraBusinessException("not found sing info in the system");
        KaraSingInfo singInfo = karaOp.get();
        Optional<KaraHeaderFeeConfig> headerOp = headerFeeConfigRepository.getHeaderByCode(singInfo.getHeaderCode());
        if (!karaOp.isPresent()) throw new KaraBusinessException("kara fee not found");
        Optional<KaraSongFeeConfig> songOp = songFeeConfigRepository.getSongByCode(singInfo.getCodeSong());
        if (!songOp.isPresent()) throw new KaraBusinessException("song fee not found!");
        KaraHeaderFeeConfig headerFeeConfig = headerOp.get();
        KaraSongFeeConfig songFeeConfig = songOp.get();

        if (songFeeConfig.getFromMin() == null || songFeeConfig.getToMin() == null) return 0;

        long totalFee = (songFeeConfig.getToMin() - songFeeConfig.getFromMin()) * songFeeConfig.getFeePerMin() + headerFeeConfig.getUsingFee();
        return totalFee;
    }

    public long calculateSingFeeByDate(Timestamp start, Timestamp end) throws InterruptedException {
        int idStart = 0;
        long totalFee = 0;
        int pageSleep = 0;
        while (true) {
            List<KaraSingInfo> karaSingInfoList = singInfoRepository.getKaraSingInfoByDate(start, end, idStart);
            for (KaraSingInfo karaInfo : karaSingInfoList) {
                totalFee += calculateSingFee(karaInfo.getRequestId());
            }
            if (karaSingInfoList.size() < 1024) break;
            idStart = karaSingInfoList.get(karaSingInfoList.size() - 1).getId();
            pageSleep++;
            if (pageSleep % 5 == 0) Thread.sleep(1000);
        }
        return totalFee;
    }
}
