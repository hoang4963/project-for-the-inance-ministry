package com.its.xoso.repository;

import com.its.xoso.entity.BaoVeTangOdon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaoVeTangOdonRepository extends JpaRepository<BaoVeTangOdon, Integer> {

    @Query("SELECT b FROM BaoVeTangOdon b " +
            "WHERE (:tinh IS NULL OR b.tinh = :tinh) " +
            "AND (:linhVuc IS NULL OR b.linhVuc = :linhVuc) " +
            "AND (:donVi IS NULL OR b.donViBaoCao = :donVi)" +
            "AND (:nam IS NULL OR b.nam = :nam)")
    List<BaoVeTangOdon> findByTinhAndLinhVucAndDonVi(
            @Param("tinh") Integer tinh,
            @Param("linhVuc") Integer linhVuc,
            @Param("nam") Integer nam,
            @Param("donVi") Integer donVi
    );


}
