package com.nekol.controller;

import com.nekol.entity.Customer;
import com.nekol.entity.Device;
import com.nekol.entity.Service;
import com.nekol.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping(value = "/add-service")
    public String addService(ModelMap modelMap) {
        Service service = new Service();
        modelMap.put("service", service);

        return "service/add-service";
    }

    @PostMapping(value = "/add-service")
    public String addService(@ModelAttribute("service") @Validated Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "service/add-service";
        }
        serviceService.addService(service);

        return "redirect:/list-service";
    }

    @GetMapping(value = {"/list-service", "/list-service/page={pageId}"})
    public String listService(ModelMap modelMap, @RequestParam(required = false) String keyword, @PathVariable(required = false) Integer pageId) {
        List<Service> services = null;
        int totalPage = 0;
        if(pageId == null) {
            pageId = 1;
        }
        if(keyword != null) {
            Page<Service> page = serviceService.getAllService(keyword, pageId);
            services = page.getContent();
            totalPage = page.getTotalPages();
            modelMap.put("keyword", keyword);

       } else {
            Page<Service> page = serviceService.getAllService(null, pageId);
           services = page.getContent();
           totalPage = page.getTotalPages();
       }
        modelMap.put("services", services);
        modelMap.put("totalPage", totalPage);
        return "service/list-service";
    }

    @GetMapping(value = "/edit-service/{id}")
    public String editService(@PathVariable String id, ModelMap modelMap) {
        modelMap.put("service", serviceService.getServiceById(id));

        return "service/edit-service";
    }

    @PostMapping(value = "/edit-service/{id}")
    public String editService(@ModelAttribute("service") @Validated Service service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "service/edit-service";
        }
        serviceService.updateService(service);

        return "redirect:/list-service";
    }

    @GetMapping(value = "/delete-service/{id}")
    public String deleteService(@PathVariable String id) {
        serviceService.deleteService(id);

        return "redirect:/list-service";
    }
}
