package com.nekol.repository;

import com.nekol.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

    @Query(value = "SELECT * FROM DICHVU  WHERE MaDV LIKE %:keyword% OR TenDV LIKE %:keyword% OR DonViTinh LIKE %:keyword% OR DonGia LIKE %:keyword%", nativeQuery = true)
    Page<Service> search(@Param("keyword") String keyword, Pageable pageable);
}
