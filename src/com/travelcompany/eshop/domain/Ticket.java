package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.PaymentMethod;

public class Ticket {
    private Long id;
    private Customer customer;
    private Itinerary itinerary;
    private PaymentMethod paymentMethod;
    private double paymentAmount;
}
