package com.its.xoso.repository;

import com.its.xoso.entity.LinhVuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhVucRepository extends JpaRepository<LinhVuc, Integer> {
    LinhVuc findByTen(String ten);
}
