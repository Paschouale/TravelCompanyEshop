package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.PaymentMethod;

public class Ticket {
    private Long id;
    private Customer customer;
    private Itinerary itinerary;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public Ticket(Long id, Customer customer, Itinerary itinerary, PaymentMethod paymentMethod, double paymentAmount) {
        this.id = id;
        this.customer = customer;
        this.itinerary = itinerary;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}
