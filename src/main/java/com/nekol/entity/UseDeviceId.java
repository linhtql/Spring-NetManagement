package com.nekol.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
public class UseDeviceId implements Serializable {

    private String customerId;

    private String deviceId;

    @Column(name = "NgayBayDauSuDung")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @Column(name = "GioBatDauSuDung")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @DateTimeFormat(pattern = "hh:mm")
    private String createTime;

    public UseDeviceId() {
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "UseDeviceId{" +
                "customerId='" + customerId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", createDate=" + createDate +
//                ", createTime=" + createTime +
                '}';
    }
}
