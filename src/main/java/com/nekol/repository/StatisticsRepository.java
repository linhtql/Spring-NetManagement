package com.nekol.repository;

import com.nekol.dto.StatisticsDTO;
import com.nekol.entity.Customer;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Repository
public interface StatisticsRepository extends JpaRepository<Customer, String> {


    @Query(value = "select kh.maKH, kh.TenKH, m.MaMay, m.ViTri, m.TrangThai, " +
            "sdm.NgayBayDauSuDung, sdm.GioBatDauSuDung, sdm.ThoiGianSuDung, dv.MaDV, sddv.NgaySuDung, sddv.GioSuDung," +
            "sddv.SoLuong, tongTien.Total as TongTien " +
            "from KHACHHANG kh " +
            "left join SUDUNGDICHVU sddv on sddv.MaKH=kh.MaKH " +
            "left join DICHVU dv on dv.MaDV=sddv.MaDV " +
            "left join SUDUNGMAY sdm on kh.MaKH=sdm.MaKH " +
            "left join MAY m on m.MaMay =sdm.MaMay " +
            "left join (select kh.maKH , SUM(sddv.SoLuong*dv.DonGia) as Total " +
            "from SUDUNGDICHVU sddv " +
            "join KHACHHANG kh on sddv.MaKH=kh.MaKH " +
            "join DICHVU dv on dv.MaDV=sddv.MaDV " +
            "group by kh.MaKH) " +
            "as tongTien on tongTien.MaKH=kh.MaKH ", nativeQuery = true)
    List<Object[]> statistics();


}
