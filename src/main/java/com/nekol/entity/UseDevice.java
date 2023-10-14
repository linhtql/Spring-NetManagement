package com.nekol.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUDUNGMAY")
public class UseDevice {

    @EmbeddedId
    private UseDeviceId useDeviceId;

    @ManyToOne
    @MapsId(value = "customerId")
    @JoinColumn(name = "MaKH")
    private Customer customer;

    @ManyToOne
    @MapsId(value = "deviceId")
    @JoinColumn(name = "MaMay")
    private Device device;

    @Column(name = "ThoiGianSuDung")
    private Double timeOfUse;

    public UseDevice() {
    }

    public UseDeviceId getUseDeviceId() {
        return useDeviceId;
    }

    public void setUseDeviceId(UseDeviceId useDeviceId) {
        this.useDeviceId = useDeviceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Double getTimeOfUse() {
        return timeOfUse;
    }

    public void setTimeOfUse(Double timeOfUse) {
        this.timeOfUse = timeOfUse;
    }

    @Override
    public String toString() {
        return "UseDevice{" +
                "useDeviceId=" + useDeviceId +
                ", customer=" + customer +
                ", device=" + device +
                ", timeOfUse=" + timeOfUse +
                '}';
    }
}
