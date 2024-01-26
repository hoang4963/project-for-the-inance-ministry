package com.its.karaoke.repository;

import com.its.karaoke.entity.KaraHeaderFeeConfig;
import com.its.karaoke.entity.KaraSongFeeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KaraHeaderFeeConfigRepository extends JpaRepository<KaraHeaderFeeConfig, Integer> {
    @Query(value = "select h from KaraHeaderFeeConfig h where h.headerCode = :headerCode")
    Optional<KaraHeaderFeeConfig> getHeaderByCode(@Param("headerCode") String headerCode);
}
