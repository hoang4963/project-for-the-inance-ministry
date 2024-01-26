package com.its.karaoke.facade;

import com.its.karaoke.entity.KaraSingInfo;
import com.its.karaoke.entity.KaraSupplier;
import com.its.karaoke.repository.KaraSingInfoRepository;
import com.its.karaoke.request.CalculateFeeByDateRequest;
import com.its.karaoke.request.KaraPushSingRequest;
import com.its.karaoke.request.SignSupRequest;
import com.its.karaoke.service.KaraSingService;
import io.sentry.Sentry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Log4j2
@Component
public class KaraFacade {

    @Autowired
    private KaraSingInfoRepository singInfoRepository;

    @Autowired
    private KaraSingService singService;

    public boolean pushSing(KaraPushSingRequest request) {
        try {
            if (request == null) {
                log.error("Invalid request");
                return false;
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = dateFormat.parse(request.getTime());
            Timestamp timestamp = new Timestamp(time.getTime());

            KaraSingInfo karaSingInfo = singService.createKaraSingInfo(request, timestamp);

            singInfoRepository.save(karaSingInfo);

            return true;
        } catch (Exception e) {
            Sentry.captureException(e);
            log.error("Push sing failed because: {}", e.getMessage());
            return false;
        }
    }

    public Map<String, Object> signSup(SignSupRequest request) {
        KaraSupplier karaSupplier = new KaraSupplier();

        karaSupplier.setName(request.getName());
        karaSupplier.setCpCode(request.getCpCode());
        karaSupplier.setDescription(request.getDescription());

        Map<String, Object> map = new HashMap<>();
        map.put("cp_code", karaSupplier.getCpCode());
        map.put("name", karaSupplier.getName());
        return map;
    }

    public long calculateFeeByDate(CalculateFeeByDateRequest request) throws ParseException, InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = dateFormat.parse(request.getFromDate());
        Date endDate = dateFormat.parse(request.getToDate());
        Timestamp timeStart = new Timestamp(startDate.getTime());
        Timestamp timeEnd = new Timestamp(endDate.getTime());

        return singService.calculateSingFeeByDate(timeStart, timeEnd);
    }
}
