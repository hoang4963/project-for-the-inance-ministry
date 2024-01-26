package com.its.karaoke.repository;

import com.its.karaoke.entity.KaraSongFeeConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KaraSongFeeConfigRepository extends JpaRepository<KaraSongFeeConfig, Integer> {

    @Query(value = "select f from KaraSongFeeConfig f where f.songCode = :songCode")
    Optional<KaraSongFeeConfig> getSongByCode(@Param("songCode") String songCode);
}
