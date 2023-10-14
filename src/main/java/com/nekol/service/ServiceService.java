package com.nekol.service;

import com.nekol.entity.Service;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ServiceService {

    void addService(Service service);
    Page<Service> getAllService(String keyword, int pageId);
    Service getServiceById(String id);
    void updateService(Service service);
    void deleteService(String id);
    List<Service> getAllService();
}
