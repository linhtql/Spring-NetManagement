package com.nekol.repository;

import com.nekol.entity.Customer;
import com.nekol.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM KHACHHANG  WHERE MaKH LIKE %:keyword% OR TenKH LIKE %:keyword% OR DiaChi LIKE %:keyword% OR SoDienThoai LIKE %:keyword% OR DiaChiEmail LIKE %:keyword%", nativeQuery = true)
    Page<Customer> search(@Param("keyword") String keyword, Pageable pageable);
}
