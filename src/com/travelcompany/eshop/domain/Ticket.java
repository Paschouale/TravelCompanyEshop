package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.PaymentMethod;

public class Ticket {
    private Long id;
    private Customer customer;
    private Itinerary itinerary;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public Ticket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod) {
        this.customer = customer;
        this.itinerary = itinerary;
        this.paymentMethod = paymentMethod;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customer id=" + customer.getId() +
                ", itinerary id=" + itinerary.getId() +
                ", paymentMethod=" + paymentMethod +
                ", paymentAmount=" + paymentAmount +
                '}';
    }
}
