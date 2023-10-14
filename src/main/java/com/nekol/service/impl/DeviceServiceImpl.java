package com.nekol.service.impl;

import com.nekol.entity.Device;
import com.nekol.repository.DeviceRepository;
import com.nekol.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public void addDevice(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public Page<Device> getAllDevice(String keyword, int pageId) {

        if(keyword != null) {
            return deviceRepository.search(keyword, PageRequest.of(--pageId, 5));
        }
        return deviceRepository.findAll(PageRequest.of( --pageId, 5));
    }

    @Override
    public Device getDeviceById(String id) {
        return deviceRepository.findById(id).get();
    }

    @Override
    public void updateDevice(Device device) {
         deviceRepository.save(device);
    }

    @Override
    public void deleteDevice(String id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }

}
