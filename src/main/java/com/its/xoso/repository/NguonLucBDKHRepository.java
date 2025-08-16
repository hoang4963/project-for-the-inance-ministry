package com.its.xoso.repository;

import com.its.xoso.entity.NguonLucBDKH;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NguonLucBDKHRepository extends JpaRepository<NguonLucBDKH, Integer> {

    @Query("SELECT n FROM NguonLucBDKH n " +
            "WHERE (:tinh IS NULL OR n.tinh = :tinh) " +
            "AND (:linhVuc IS NULL OR n.linhVuc = :linhVuc) " +
            "AND (:nam IS NULL OR n.nam = :nam) " +
            "AND (:donViBaoCao IS NULL OR n.donViBaoCao = :donViBaoCao)" +
            "AND (:tieuChi IS NULL OR n.tieuChi = :tieuChi)")
    Page<NguonLucBDKH> searchNguonLuc(Integer tinh, Integer linhVuc, Integer nam, Integer donViBaoCao, Integer tieuChi, Pageable pageable);

}
