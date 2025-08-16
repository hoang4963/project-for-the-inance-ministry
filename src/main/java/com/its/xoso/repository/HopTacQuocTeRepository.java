package com.its.xoso.repository;

import com.its.xoso.entity.HopTacQuocTe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HopTacQuocTeRepository extends JpaRepository<HopTacQuocTe, Integer> {

    @Query("SELECT h FROM HopTacQuocTe h " +
            "WHERE (:tinh IS NULL OR h.tinh = :tinh) " +
            "AND (:linhVuc IS NULL OR h.linhVuc = :linhVuc) " +
            "AND (:donViBaoCao IS NULL OR h.donViBaoCao = :donViBaoCao) " +
            "AND (:nam IS NULL OR h.nam = :nam)" +
            "AND (:tieuChi IS NULL OR h.tieuChi = :tieuChi)")
    List<HopTacQuocTe> searchHopTacQuocTe(
            @Param("tinh") Integer tinh,
            @Param("linhVuc") Integer linhVuc,
            @Param("donViBaoCao") Integer donViBaoCao,
            @Param("nam") Integer nam,
            @Param("tieuChi") Integer tieuChi
    );
}
