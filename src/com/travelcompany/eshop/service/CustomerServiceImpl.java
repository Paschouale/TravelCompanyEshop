package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.exception.CustomerEmailException;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        if (customer.getEmail().endsWith("travelcompany.com")) {
            throw new CustomerEmailException("You've entered an invalid email address");
        }
        customers.add(customer);

    }

    @Override
    public void addAll(List<Customer> customers) {
        for (Customer customer : customers) {
            try {
                if (customer.getEmail().endsWith("travelcompany.com")) {
                    throw new CustomerEmailException("You've entered an invalid email address");
                }
                this.customers.add(customer);
            } catch (CustomerEmailException e) {
                System.out.println("The customer with ID: " + customer.getId() + " has an invalid address: " + customer.getEmail());
            }
//        this.customers.addAll(customers);
        }
    }

        @Override
        public List<Customer> getCustomerList () {
            return customers;
        }

        @Override
        public Customer getById (Long id){
            for (Customer customer : customers) {
                if (customer.getId().equals(id)) {
                    return customer;
                }
            }
            return null;
        }


    }
