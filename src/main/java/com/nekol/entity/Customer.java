package com.nekol.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "KHACHHANG")
public class Customer {

    @Id
    @Column(name = "MaKH")
    @NotEmpty(message = "Code is required")
    @Pattern(regexp = "^KH\\d{5}$", message = "Code is incorrect format")
    private String id;

    @Column(name = "TenKH")
    @NotEmpty(message = "Name is required")
    private String name;
    @Column(name = "DiaChi")
    @NotEmpty(message = "Address is required")
    private String address;
    @Column(name = "SoDienThoai")
    @NotEmpty(message = "Phone is required")
//    @Pattern(regexp = "^090|091|8490|8491\\d{7}$", message = "Phone is incorrect format!")
    private String phone;
    @Column(name = "DiaChiEmail")
    @Email(message = "Email is incorrect format")
    @NotEmpty(message = "Email is required")
    private String email;

    @OneToMany(mappedBy = "customer")
    Set<UseDevice> useDevices;

    @OneToMany(mappedBy = "customer")
    Set<UseService> useServices;

    public Customer() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UseDevice> getUseDevices() {
        return useDevices;
    }

    public void setUseDevices(Set<UseDevice> useDevices) {
        this.useDevices = useDevices;
    }

    public Set<UseService> getUseServices() {
        return useServices;
    }

    public void setUseServices(Set<UseService> useServices) {
        this.useServices = useServices;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", useDevices=" + useDevices +
                ", useServices=" + useServices +
                '}';
    }
}
