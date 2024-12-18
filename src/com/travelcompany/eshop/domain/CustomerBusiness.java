package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;

public class CustomerBusiness extends Customer{

    private Category category = Category.BUSINESS;

    public CustomerBusiness(Long id, String name, String email, String address, Nationality nationality) {
        super(id, name, email, address, nationality);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return super.toString() +
                " category=" + category +
                '}';
    }
}
