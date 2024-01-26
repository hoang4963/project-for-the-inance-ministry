package com.its.karaoke.repository;

import com.its.karaoke.entity.KaraSingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface KaraSingInfoRepository extends JpaRepository<KaraSingInfo, Integer> {

    @Query(value = "select s from KaraSingInfo s where s.requestId = :requestId")
    Optional<KaraSingInfo> getSingInfoByRequestId(@Param("requestId") String requestId);

    @Query(value = "select s.* from kara_sing_info s where s.updated_at > :start and s.updated_at < :end and s.id > :idStart limit 1024", nativeQuery = true)
    List<KaraSingInfo> getKaraSingInfoByDate(@Param("start") Timestamp start, @Param("end") Timestamp end, @Param("idStart") int idStart);
}
