package com.nekol.dto;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class StatisticsDTO implements Serializable {

    private String customerId;
    private String customerName;
    private String deviceId;
    private String location;
    private String status;
    private LocalDate dayBeganDevice;
    private LocalTime timeBeganDevice;
    private Double timeOfUse;
    private String serviceId;
    private LocalDate dayBeganService;
    private LocalTime timeBeganService;
    private int amount;
    private Double total;

    public StatisticsDTO() {
    }

    public StatisticsDTO(String customerId, String customerName, String deviceId, String location, String status, LocalDate dayBeganDevice, LocalTime timeBeganDevice, Double timeOfUse, String serviceId, LocalDate dayBeganService, LocalTime timeBeganService, int amount, Double total) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.deviceId = deviceId;
        this.location = location;
        this.status = status;
        this.dayBeganDevice = dayBeganDevice;
        this.timeBeganDevice = timeBeganDevice;
        this.timeOfUse = timeOfUse;
        this.serviceId = serviceId;
        this.dayBeganService = dayBeganService;
        this.timeBeganService = timeBeganService;
        this.amount = amount;
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDayBeganDevice() {
        return dayBeganDevice;
    }

    public void setDayBeganDevice(LocalDate dayBeganDevice) {
        this.dayBeganDevice = dayBeganDevice;
    }

    public LocalTime getTimeBeganDevice() {
        return timeBeganDevice;
    }

    public void setTimeBeganDevice(LocalTime timeBeganDevice) {
        this.timeBeganDevice = timeBeganDevice;
    }

    public Double getTimeOfUse() {
        return timeOfUse;
    }

    public void setTimeOfUse(Double timeOfUse) {
        this.timeOfUse = timeOfUse;
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

    public LocalTime getTimeBeganService() {
        return timeBeganService;
    }

    public void setTimeBeganService(LocalTime timeBeganService) {
        this.timeBeganService = timeBeganService;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
