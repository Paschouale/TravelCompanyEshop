package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.PaymentMethod;
import com.travelcompany.eshop.service.*;

import java.util.List;

public class TravelCompanyEshop {
    public static void main(String[] args) {

        // Δημιουργία για τα 3 services
        CustomerService customerService = new CustomerServiceImpl();
        ItineraryService itineraryService = new ItineraryServiceImpl();
        TicketService ticketService = new TicketServiceImpl();

        // Καταχώρηση πελατών στη λίστα
        customerService.addAll(TravelCompanyServiceHandlers.loadCustomers());
        List<Customer> customers = customerService.getCustomerList();

        // Καταχώρηση δρομολογίων στη λίστα
        itineraryService.addAll(TravelCompanyServiceHandlers.loadItineraries());
        List<Itinerary> itineraries = itineraryService.getItineraryList();

        //Αγορά εισιτηρίων και add σε λίστα.
        ticketService.buyTicket(customers.get(0), itineraries.get(5), PaymentMethod.CREDIT_CARD);
        ticketService.buyTicket(customers.get(1), itineraries.get(0), PaymentMethod.CASH);
        ticketService.buyTicket(customers.get(2), itineraries.get(1), PaymentMethod.CREDIT_CARD);
        ticketService.buyTicket(customers.get(3), itineraries.get(2), PaymentMethod.CREDIT_CARD);
        ticketService.buyTicket(customers.get(4), itineraries.get(3), PaymentMethod.CASH);
        ticketService.buyTicket(customers.get(5), itineraries.get(4), PaymentMethod.CASH);
        ticketService.buyTicket(customers.get(6), itineraries.get(6), PaymentMethod.CREDIT_CARD);
        List<Ticket> ticketList = ticketService.getTicketList();

        for (Ticket ticket: ticketList)
            System.out.println(ticket);
    }
}
