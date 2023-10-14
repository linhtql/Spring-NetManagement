package com.nekol.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class UseServiceId implements Serializable {

    private String customerId;
    private String serviceId;
    @Column(name = "NgaySuDung")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayBeganService;
    @Column(name = "GioSuDung")
    @DateTimeFormat(pattern = "hh:mm")
    private String timeBeganService;

    public UseServiceId() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getDayBeganService() {
        return dayBeganService;
    }

    public void setDayBeganService(LocalDate dayBeganService) {
        this.dayBeganService = dayBeganService;
    }

    public String getTimeBeganService() {
        return timeBeganService;
    }

    public void setTimeBeganService(String timeBeganService) {
        this.timeBeganService = timeBeganService;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
