package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceHandler {
    public static void noTicketCustomers (List<Ticket> ticketList, List<Customer> customerList){
        List<Customer> customersWithNoTickets = new ArrayList<>();
        for (Customer customer: customerList){
            boolean hasTicket = false;
            for (Ticket ticket : ticketList){
                if ( customer.getId() == ticket.getCustomer().getId() ){
                    hasTicket = true;
                }
            }
            if (!hasTicket){
                customersWithNoTickets.add(customer);
            }
        }
        System.out.println("The Customers with no tickets are: ");
        for (Customer customer: customersWithNoTickets){
            System.out.println(customer);
        }
    }
}
