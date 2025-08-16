package com.its.xoso.repository;

import com.its.xoso.entity.LoaiHinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiHinhRepository extends JpaRepository<LoaiHinh, Integer> {
    LoaiHinh findByTen(String name);
}