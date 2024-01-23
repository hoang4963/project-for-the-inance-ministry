package com.its.karaoke.repository;

import com.its.karaoke.entity.KaraVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KaraVendorRepository extends JpaRepository<KaraVendor, Integer> {

    @Query("select v from KaraVendor v where v.username = :username")
    KaraVendor findVendorByUsername(@Param("username") String username);
}
