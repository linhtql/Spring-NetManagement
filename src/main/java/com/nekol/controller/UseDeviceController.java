package com.nekol.controller;

import com.nekol.entity.*;
import com.nekol.service.CustomerService;
import com.nekol.service.DeviceService;
import com.nekol.service.ServiceService;
import com.nekol.service.UseDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UseDeviceController {

    @Autowired
    CustomerService customerService;

    @Autowired
    DeviceService deviceService;

    @Autowired
    UseDeviceService useDeviceService;

    @GetMapping(value = "/register-use-device")
    public String registerUseDevice(ModelMap modelMap) {
        UseDevice useDevice = new UseDevice();

        modelMap.put("useDevice", useDevice);

        List<Customer> customers = customerService.getAllCustomer();
        modelMap.put("customers", customers);

        List<Device> devices = deviceService.getAllDevice();
        modelMap.put("devices", devices);

        return "register/register-use-device";
    }

    @PostMapping(value = "/register-use-device")
    public String registerUseDevice(@ModelAttribute("useDevice") UseDevice useDevice) {

        useDevice.setCustomer(customerService.getCustomerById(useDevice.getUseDeviceId().getCustomerId()));
        useDevice.setDevice(deviceService.getDeviceById(useDevice.getUseDeviceId().getDeviceId()));

        useDeviceService.save(useDevice);
        return "/";
    }
}
