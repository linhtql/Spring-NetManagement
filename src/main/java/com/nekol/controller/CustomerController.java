package com.nekol.controller;

import com.nekol.entity.Customer;
import com.nekol.entity.Device;
import com.nekol.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/add-customer")
    public String addCustomer(ModelMap modelMap) {
        Customer customer = new Customer();
        modelMap.put("customer", customer);

        return "customer/add-customer";
    }

    @PostMapping(value = "/add-customer")
    public String addCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/add-customer";
        }
        Customer existingCustomer = customerService.getCustomerById(customer.getId());
        if (existingCustomer != null) {
            return "redirect:/exists-error";

        } else {
            customerService.addCustomer(customer);
            return "redirect:/list-customer";
        }

    }

    @GetMapping(value = "/check-customer-code")
    public @ResponseBody String checkCustomerCode(@RequestParam String code) {
        if (customerService.getCustomerById(code) != null) {
            return "exists";
        } else {
            return "not-exists";
        }
    }

    @GetMapping(value = {"/list-customer/page={pageId}", "/list-customer"})
    public String listCustomer(ModelMap modelMap, @RequestParam(required = false) String keyword, @PathVariable(required = false) Integer pageId) {
        if(pageId == null) {
            pageId =1;
        }
        List<Customer> customers = null;
        int totalPage = 0;
        if (keyword != null) {
            Page<Customer> page = customerService.getAllCustomer(keyword, pageId);
            customers = page.getContent();
            totalPage = page.getTotalPages();
            modelMap.put("keyword", keyword);

        } else {
            Page<Customer> page = customerService.getAllCustomer(null, pageId);
            customers = page.getContent();
            totalPage = page.getTotalPages();
        }
        modelMap.put("customers", customers);
        modelMap.put("totalPage", totalPage);
        return "customer/list-customer";
    }

    @GetMapping(value = "/edit-customer/{id}")
    public String editCustomer(@PathVariable String id, ModelMap modelMap) {
        modelMap.put("customer", customerService.getCustomerById(id));

        return "customer/edit-customer";
    }

    @PostMapping(value = "/edit-customer/{id}")
    public String editCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer/edit-customer";
        }
        customerService.updateCustomer(customer);

        return "redirect:/list-customer";
    }

    @GetMapping(value = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);

        return "redirect:/list-customer";
    }

    @GetMapping("/exists-error")
    public String existsError() {
        return "error/error";
    }

}
