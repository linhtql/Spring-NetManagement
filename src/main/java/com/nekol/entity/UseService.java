package com.nekol.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "SUDUNGDICHVU")
public class UseService {

    @EmbeddedId
    private UseServiceId useServiceId;

   @ManyToOne
   @MapsId(value = "customerId")
   @JoinColumn(name = "MaKH")
   private Customer customer;

    @ManyToOne
    @MapsId(value = "serviceId")
    @JoinColumn(name = "MaDV")
    private Service service;

    @Column(name = "SoLuong")
    private int amount;

    public UseService() {
    }

    public UseServiceId getUseServiceId() {
        return useServiceId;
    }

    public void setUseServiceId(UseServiceId useServiceId) {
        this.useServiceId = useServiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
