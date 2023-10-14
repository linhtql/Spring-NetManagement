package com.nekol.controller;

import com.nekol.entity.Device;
import com.nekol.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping(value = "/add-device")
    public String addDevice(ModelMap modelMap) {
        Device device = new Device();
        modelMap.put("device", device);
        return "device/add-device";
    }

    @PostMapping(value = "/add-device")
    public String addDevice(@ModelAttribute("device") @Validated Device device, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "device/add-device";
        }
        deviceService.addDevice(device);
        return "redirect:/list-device";
    }

    @GetMapping(value = {"/list-device/page={pageId}", "/list-device"})
    public String getAllDevice(ModelMap modelMap, @RequestParam(required = false) String keyword, @PathVariable(required = false) Integer pageId) {
        if(pageId == null) {
            pageId = 1;
        }
        List<Device> devices = null;
        int totalPage = 0;

        if (keyword != null) {
            Page<Device> page = deviceService.getAllDevice(keyword, pageId);
            devices = page.getContent();
            totalPage = page.getTotalPages();
            modelMap.put("keyword", keyword);
        } else {
            Page<Device> page = deviceService.getAllDevice(null, pageId);
            devices = page.getContent();
            totalPage = page.getTotalPages();
        }
        modelMap.put("devices", devices);
        modelMap.put("totalPage", totalPage);
        return "device/list-device";
    }

    @GetMapping(value = "/edit-device/{id}")
    public String editDevice(@PathVariable String id, ModelMap modelMap) {
        modelMap.put("device",  deviceService.getDeviceById(id));
        return "device/edit-device";
    }

    @PostMapping(value = "/edit-device/{id}")
    public String editDevice(@ModelAttribute("device")  @Validated Device device, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "device/edit-device";
        }
        deviceService.updateDevice(device);
        return "redirect:/list-device";
    }

    @GetMapping(value = "/delete-device/{id}")
    public String deleteDevice(@PathVariable String id) {
        deviceService.deleteDevice(id);
        return "redirect:/list-device";
    }


}
