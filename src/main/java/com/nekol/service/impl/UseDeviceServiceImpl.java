package com.nekol.service.impl;

import com.nekol.entity.UseDevice;
import com.nekol.repository.UseDeviceRepository;
import com.nekol.service.UseDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseDeviceServiceImpl implements UseDeviceService {

    @Autowired
    UseDeviceRepository useDeviceRepository;

    @Override
    public void save(UseDevice useDevice) {
        useDeviceRepository.save(useDevice);
    }
}
