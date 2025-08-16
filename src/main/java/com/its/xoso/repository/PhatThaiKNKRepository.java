package com.its.xoso.repository;

import com.its.xoso.entity.PhatThaiKNK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhatThaiKNKRepository extends JpaRepository<PhatThaiKNK, Integer> {

    @Query("SELECT p FROM PhatThaiKNK p " +
            "WHERE (:linhVuc IS NULL OR p.linhVuc = :linhVuc) " +
            "AND (:tinh IS NULL OR p.tinh = :tinh) " +
            "AND (:nam IS NULL OR p.nam = :nam) " +
            "AND (:nguonTacDong IS NULL OR p.nguonTacDong = :nguonTacDong)" +
            "AND (:donVi IS NULL OR p.donViBaoCao = :donVi)")
    List<PhatThaiKNK> findAllByConditions(
            @Param("linhVuc") Integer linhVuc,
            @Param("tinh") Integer tinh,
            @Param("nam") Integer nam,
            @Param("nguonTacDong") Integer nguonTacDong,
            @Param("donVi") Integer donVi
    );
}
