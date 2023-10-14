package com.nekol.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "MAY")
public class Device {
    @Id
    @Column(name = "MaMay")
    @NotEmpty (message = "Code is required!")
    private String id;

    @Column(name = "ViTri")
    @NotEmpty (message = "Location is required!")
    private String location;

    @Column(name = "TrangThai")
    private String status;

    @OneToMany(mappedBy = "device")
    private Set<UseDevice> useDevices;

    public Device(String id, String location, String status) {
        this.id = id;
        this.location = location;
        this.status = status;
    }

    public Device() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Set<UseDevice> getUseDevices() {
        return useDevices;
    }

    public void setUseDevices(Set<UseDevice> useDevices) {
        this.useDevices = useDevices;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
