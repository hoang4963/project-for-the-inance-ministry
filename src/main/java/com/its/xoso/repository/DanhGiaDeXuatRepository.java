package com.its.xoso.repository;

import com.its.xoso.entity.DanhGiaDeXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhGiaDeXuatRepository extends JpaRepository<DanhGiaDeXuat, Integer> {

    @Query("SELECT d FROM DanhGiaDeXuat d " +
            "WHERE (:tinhId IS NULL OR d.tinh = :tinhId) " +
            "AND (:linhVucId IS NULL OR d.linhVuc = :linhVucId) " +
            "AND (:nam IS NULL OR d.nam = :nam)")
    Page<DanhGiaDeXuat> searchDanhGiaDeXuat(
            @Param("tinhId") Integer tinhId,
            @Param("linhVucId") Integer linhVucId,
            @Param("nam") Integer nam,
            Pageable pageable
    );
}
