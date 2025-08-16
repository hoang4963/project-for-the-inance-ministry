package com.its.xoso.repository;

import com.its.xoso.entity.NghienCuuKHCN;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NghienCuuKHCNRepository extends JpaRepository<NghienCuuKHCN, Integer> {

    @Query("SELECT n FROM NghienCuuKHCN n " +
            "WHERE (:tinh IS NULL OR n.tinh = :tinh) " +
            "AND (:linhVuc IS NULL OR n.linhVuc = :linhVuc) " +
            "AND (:nam IS NULL OR n.nam = :nam) " +
            "AND (:donViBaoCao IS NULL OR n.donViBaoCao = :donViBaoCao)")
    Page<NghienCuuKHCN> search(
            @Param("tinh") Integer tinh,
            @Param("linhVuc") Integer linhVuc,
            @Param("nam") Integer nam,
            @Param("donViBaoCao") Integer donViBaoCao,
            Pageable pageable
    );
}