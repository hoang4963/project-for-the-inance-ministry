package com.its.xoso.repository;

import com.its.xoso.entity.DonVi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonViRepository extends JpaRepository<DonVi, Integer> {
    DonVi findByTen(String name);
}
