package com.its.xoso.repository;

import com.its.xoso.entity.GiamNheThichUng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamNheThichUngRepository extends JpaRepository<GiamNheThichUng, Integer> {

    @Query("SELECT g FROM GiamNheThichUng g " +
            "WHERE (:linhVucId IS NULL OR g.linhVuc = :linhVucId) " +
            "AND (:tinhId IS NULL OR g.tinh = :tinhId) " +
            "AND (:nam IS NULL OR g.nam = :nam) " +
            "AND (:loaiHinhId IS NULL OR g.loaiHinh = :loaiHinhId) " +
            "AND (:donViBaoCao IS NULL OR g.donViBaoCao = :donViBaoCao)" +
            "AND (:danhMuc IS NULL OR g.danhMuc = :danhMuc)")
    List<GiamNheThichUng> findByConditions(
            @Param("linhVucId") Integer linhVucId,
            @Param("tinhId") Integer tinhId,
            @Param("nam") Integer nam,
            @Param("loaiHinhId") Integer loaiHinhId,
            @Param("donViBaoCao") Integer donViBaoCao,
            @Param("danhMuc") Integer danhMuc
    );
}
