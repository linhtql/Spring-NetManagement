package com.nekol.repository;

import com.nekol.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {

    @Query(value = "SELECT * FROM MAY  WHERE MaMay LIKE %:keyword% OR TrangThai LIKE %:keyword% OR ViTri LIKE %:keyword%", nativeQuery = true)
    Page<Device> search(@Param("keyword") String keyword, Pageable pageable);
}
