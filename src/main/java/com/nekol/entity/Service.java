package com.nekol.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "DICHVU")
public class Service {

    @Id
    @Column(name = "MaDV")
    @Pattern(regexp = "^DV\\d{3}$", message = "Code is incorrect format!")
    @NotEmpty(message = "Code is required!")
    private String id;
    @Column(name = "TenDV")
    @NotEmpty(message = "Name is required!")
    private String name;
    @Column(name = "DonViTinh")
    private String unit;
    @Column(name = "DonGia")
    @DecimalMin(value = "0.1", message = "Please Enter a valid number")
    private double price;

    @OneToMany(mappedBy = "service")
    private Set<UseService> useServices;

    public Service() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<UseService> getUseServices() {
        return useServices;
    }

    public void setUseServices(Set<UseService> useServices) {
        this.useServices = useServices;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", useServices=" + useServices +
                '}';
    }
}
