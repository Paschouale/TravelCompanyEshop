package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.exception.CustomerEmailException;

public abstract class Customer {

    private Long id;
    private String name;
    private String email;
    private String address;
    private Nationality nationality;

    public Customer(Long id, String name, String email, String address, Nationality nationality) {
        if ( email.endsWith("@travelcompany.com") ){
            throw new CustomerEmailException("The email for the customer with id: " + id + " is invalid");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public abstract Category getCategory();

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationality=" + nationality +
                ',';
    }
}
