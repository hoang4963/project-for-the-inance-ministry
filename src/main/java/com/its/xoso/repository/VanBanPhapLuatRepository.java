package com.its.xoso.repository;

import com.its.xoso.entity.VanBanPhapLuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VanBanPhapLuatRepository extends JpaRepository<VanBanPhapLuat, Integer> {


    @Query("SELECT vb FROM VanBanPhapLuat vb " +
            "WHERE (:loaiVB IS NULL OR vb.loaiVanBan = :loaiVB) " +
            "AND (:year IS NULL OR vb.nam = :year) " +
            "AND (:tinh IS NULL OR vb.tinh = :tinh) " +
            "AND (:linhVuc IS NULL OR vb.linhVuc = :linhvuc) " +
            "AND (:coQuan IS NULL OR vb.coQuanBanHanh = :coquan)")
    Page<VanBanPhapLuat> findAllByConditions(
            @Param("name") String loaiVB,
            @Param("year") Integer year,
            @Param("tinh") Integer tinh,
            @Param("linhVuc") Integer linhVuc,
            @Param("coQuan") String coQuan,
            Pageable pageable
    );
}
