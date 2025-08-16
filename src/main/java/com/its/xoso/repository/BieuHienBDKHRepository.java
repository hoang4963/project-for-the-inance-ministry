package com.its.xoso.repository;

import com.its.xoso.entity.BieuHienBDKH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BieuHienBDKHRepository extends JpaRepository<BieuHienBDKH, Integer> {

    @Query("SELECT b FROM BieuHienBDKH b " +
            "WHERE (:tinhId IS NULL OR b.tinh = :tinhId) " +
            "AND (:linhVucId IS NULL OR b.linhVuc = :linhVucId) " +
            "AND (:nam IS NULL OR b.nam = :nam) " +
            "AND (:donViBaoCaoId IS NULL OR b.donViBaoCao = :donViBaoCaoId)" +
            "AND (:loaiHinh IS NULL OR b.loaiHinh = :loaiHinh)")
    List<BieuHienBDKH> searchBieuHienBDKH(
            @Param("tinhId") Integer tinhId,
            @Param("linhVucId") Integer linhVucId,
            @Param("nam") Integer nam,
            @Param("donViBaoCaoId") Integer donViBaoCaoId,
            @Param("loaiHinh") Integer loaiHinh
    );
}
