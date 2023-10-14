package com.nekol.service.impl;

import com.nekol.entity.UseService;
import com.nekol.repository.UseServiceRepository;
import com.nekol.service.UseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseServiceServiceImpl implements UseServiceService {

    @Autowired
    UseServiceRepository useServiceRepository;

    @Override
    public void save(UseService useService) {
        useServiceRepository.save(useService);
    }
}
