package com.travelcompany.eshop.services;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.enumeration.PaymentMethod;

public class TravelCompanyServicesImpl implements TravelCompanyServices {


    @Override
    public Ticket selectItinerary(Customer customer, Itinerary itinerary) {
        Ticket ticket = new Ticket(1L, customer, itinerary, PaymentMethod.CREDIT_CARD);
        ticket.setPaymentAmount(ticketPrice(ticket));
        return ticket;
    }

    @Override
    public double ticketPrice(Ticket ticket) {
        double basicPrice = ticket.getItinerary().getBasicPrice();
        double discount = 0.0;
        double surcharge = 0.0;
        if (ticket.getCustomer().getCategory() == Category.BUSINESS) {
            discount += 0.1;
        }else surcharge = 0.2;
        if (ticket.getPaymentMethod() == PaymentMethod.CREDIT_CARD)
            discount += 0.1;
        double ticketPrice = basicPrice + (basicPrice*surcharge) - (basicPrice*discount);
        return ticketPrice;
    }
}
