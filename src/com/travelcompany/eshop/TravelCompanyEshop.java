package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.PaymentMethod;
import com.travelcompany.eshop.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        ticketService.buyTicket(customers.get(0), itineraries.get(0), PaymentMethod.CASH);
        ticketService.buyTicket(customers.get(2), itineraries.get(1), PaymentMethod.CREDIT_CARD);
        ticketService.buyTicket(customers.get(3), itineraries.get(2), PaymentMethod.CREDIT_CARD);
        ticketService.buyTicket(customers.get(2), itineraries.get(3), PaymentMethod.CASH);
        ticketService.buyTicket(customers.get(5), itineraries.get(4), PaymentMethod.CASH);
        ticketService.buyTicket(customers.get(3), itineraries.get(6), PaymentMethod.CREDIT_CARD);
        List<Ticket> ticketList = ticketService.getTicketList();

        totalTicketsPerCustomer(customers, ticketList);

    }

    public static void totalTicketsPerCustomer(List<Customer> customers, List<Ticket> ticketList) {


        for (Customer customer : customers) {
            int totalTickets = 0;
            double totalExpenses = 0.0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    totalTickets++;
                    totalExpenses = totalExpenses + ticket.getPaymentAmount();
                }
            }
            System.out.println(customer.getName() + " has a total number of " + totalTickets +
                    " ticket/s and has total expenses of " + totalExpenses + " euros");
        }
    }

    public static void  mostTicketCustomer(List<Customer> customers, List<Ticket> ticketList) {
        Customer mostTicketsCustomer = null;
        int mostTickets = 0;

        for (Customer customer : customers) {
            int tempTickets = 0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    tempTickets++;
                }
            }
            if (tempTickets > mostTickets) {
                mostTickets = tempTickets;
                mostTicketsCustomer = customer;
            }
        }

        System.out.println("The customer with the most tickets is: " + mostTicketsCustomer);
    }

}
