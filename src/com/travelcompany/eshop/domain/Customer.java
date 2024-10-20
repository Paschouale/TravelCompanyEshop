package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String address;
    private Nationality nationality;
    private Category category;
}
