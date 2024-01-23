package com.its.karaoke.repository;

import com.its.karaoke.entity.KaraSingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KaraSingInfoRepository extends JpaRepository<KaraSingInfo, Integer> {
}
