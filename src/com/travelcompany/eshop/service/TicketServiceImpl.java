package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private List<Ticket> ticketList = new ArrayList<>();

    @Override
    public void buyTicket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod) {
        Ticket ticket = new Ticket(customer, itinerary, paymentMethod);
        ticket.setPaymentAmount(ticketPrice(ticket));
        ticket.setId(this.ticketList.size() + 1L);
        this.ticketList.add(ticket);
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


    public List<Ticket> getTicketList() {
        return ticketList;
    }
}
