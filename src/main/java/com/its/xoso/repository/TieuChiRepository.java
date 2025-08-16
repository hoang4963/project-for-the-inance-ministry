package com.its.xoso.repository;

import com.its.xoso.entity.TieuChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieuChiRepository extends JpaRepository<TieuChi, Integer> {
    TieuChi findByDanhMuc(String danhmuc);
}
