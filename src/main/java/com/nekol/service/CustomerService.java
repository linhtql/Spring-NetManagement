package com.nekol.service;

import com.nekol.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    Page<Customer> getAllCustomer(String keyword, int pageId);

    Customer getCustomerById(String id);
    void updateCustomer(Customer customer);
    void deleteCustomer(String id);
    List<Customer> getAllCustomer();
    Customer findById(String id);
}
