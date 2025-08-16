package com.its.xoso.repository;

import com.its.xoso.entity.TacDongBDKH;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TacDongBDKHRepository extends JpaRepository<TacDongBDKH, Integer> {

    @Query("SELECT t FROM TacDongBDKH t " +
            "WHERE (:linhVucId IS NULL OR t.linhVuc = :linhVucId) " +
            "AND (:loaiHinhId IS NULL OR t.loaiHinh = :loaiHinhId) " +
            "AND (:tinhId IS NULL OR t.tinh = :tinhId) " +
            "AND (:donViBaoCaoId IS NULL OR t.donViBaoCao = :donViBaoCaoId) " +
            "AND (:nam IS NULL OR t.nam = :nam)")
    List<TacDongBDKH> findAllByConditions(
            @Param("linhVucId") Integer linhVucId,
            @Param("loaiHinhId") Integer loaiHinhId,
            @Param("tinhId") Integer tinhId,
            @Param("donViBaoCaoId") Integer donViBaoCaoId,
            @Param("nam") Integer nam
    );
}
