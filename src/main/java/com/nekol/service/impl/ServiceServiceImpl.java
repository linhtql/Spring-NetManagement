package com.nekol.service.impl;

import com.nekol.entity.Service;
import com.nekol.repository.ServiceRepository;
import com.nekol.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public void addService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Page<Service> getAllService(String keyword, int pageId) {
        if(keyword != null) {
            return serviceRepository.search(keyword, PageRequest.of(--pageId, 5));

        }
        return serviceRepository.findAll(PageRequest.of(--pageId, 5));
    }

    @Override
    public Service getServiceById(String id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void updateService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }
}
