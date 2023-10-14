package com.nekol.controller;

import com.nekol.entity.Customer;
import com.nekol.entity.Service;
import com.nekol.entity.UseService;
import com.nekol.service.CustomerService;
import com.nekol.service.ServiceService;
import com.nekol.service.UseServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UseServiceController {

    @Autowired
    UseServiceService useServiceService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService serviceService;

    @GetMapping(value = "/register-use-service")
    public String registerUseService(ModelMap modelMap) {
        UseService useService = new UseService();
        modelMap.put("useService", useService);

        List<Customer> customers = customerService.getAllCustomer();
        modelMap.put("customers", customers);

        List<Service> services = serviceService.getAllService();
        modelMap.put("services", services);


        return "register/register-use-service";
    }

    @PostMapping(value = "/register-use-service")
    public String registerUseService(@ModelAttribute("useService") UseService useService) {

        useService.setCustomer(customerService.getCustomerById(useService.getUseServiceId().getCustomerId()));
        useService.setService(serviceService.getServiceById(useService.getUseServiceId().getServiceId()));
        useServiceService.save(useService);

        return "";
    }
}
