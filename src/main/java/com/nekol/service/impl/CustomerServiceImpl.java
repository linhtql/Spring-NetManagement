package com.nekol.service.impl;

import com.nekol.entity.Customer;
import com.nekol.repository.CustomerRepository;
import com.nekol.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomer(String keyword, int pageId) {
        if(keyword != null) {
            return customerRepository.search(keyword, PageRequest.of(--pageId, 5));

        }
        return customerRepository.findAll(PageRequest.of(--pageId, 5));
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).get();
    }
}
