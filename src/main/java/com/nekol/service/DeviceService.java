package com.nekol.service;

import com.nekol.entity.Device;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeviceService {
    void addDevice(Device device);

    Page<Device> getAllDevice(String keyword, int pageId);

    Device getDeviceById(String id);
    void updateDevice(Device device);

    void deleteDevice(String id);
    List<Device> getAllDevice();
}
