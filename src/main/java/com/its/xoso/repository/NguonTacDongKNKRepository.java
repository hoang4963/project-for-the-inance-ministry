package com.its.xoso.repository;

import com.its.xoso.entity.NguonTacDongKNK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguonTacDongKNKRepository extends JpaRepository<NguonTacDongKNK, Integer> {

    @Query(value = "select ng from NguonTacDongKNK ng where (:linhVuc is null or :linhvuc = ng.linhVuc)")
    List<NguonTacDongKNK> findAllByLinhVuc(@Param("linhVuc") Integer linhVuc);


    @Query(value = "select ng from NguonTacDongKNK ng where (:linhVuc is null or :linhvuc = ng.linhVuc) and :nguonTacDong = ng.nguonTacDong")
    NguonTacDongKNK findByNguonTacDong(@Param("linhVuc") Integer linhVuc,@Param("nguonTacDong") String nguonTacDong);

}
