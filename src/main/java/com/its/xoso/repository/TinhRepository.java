package com.its.xoso.repository;

import com.its.xoso.entity.Tinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TinhRepository extends JpaRepository<Tinh, Integer> {
    Tinh findByTenTinh(String tenTinh);

}
