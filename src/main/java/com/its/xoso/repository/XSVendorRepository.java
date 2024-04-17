package com.its.xoso.repository;

import com.its.xoso.entity.XSVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface XSVendorRepository extends JpaRepository<XSVendor, Integer> {

    @Query("select v from XSVendor v where v.username = :username")
    XSVendor findVendorByUsername(@Param("username") String username);
}
