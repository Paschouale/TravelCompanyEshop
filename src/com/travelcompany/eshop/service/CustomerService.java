package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);
    void addAll(List<Customer> customers);
    Customer getById(Long id);
    List<Customer> getCustomerList();

}
