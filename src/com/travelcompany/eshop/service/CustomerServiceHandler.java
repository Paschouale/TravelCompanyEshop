package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.CustomerBusiness;
import com.travelcompany.eshop.domain.CustomerIndividual;
import com.travelcompany.eshop.domain.Ticket;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.exception.CustomerEmailException;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceHandler {
    public static List<Customer> loadCustomers() {

        List<Customer> customers = new ArrayList<>();
        try{
            customers.add(new CustomerBusiness(1L, "Dimitrios Paschalis", "d.paschalis@cosmote-evalue.gr", "Athens", Nationality.GREEK));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        try{
            customers.add(new CustomerIndividual(2L, "Yiota Plati", "p.plati@cosmote-evalue.gr", "Athens", Nationality.FRENCH));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        try{
            customers.add(new CustomerBusiness(3L, "Dimitrios Zachos", "d.zachos@ote.gr", "Milan", Nationality.ITALIAN));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        try {
            customers.add(new CustomerIndividual(4L, "Theodora Vasiladioti", "t.vasiladioti@travelcompany.com", "Thessaloniki", Nationality.GREEK));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        try{
            customers.add(new CustomerBusiness(5L, "Spyros Farantos", "s.farantos@cosmote-evalue.gr", "Lyon", Nationality.FRENCH));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        try{
            customers.add(new CustomerIndividual(6L, "Michael Vazakopoulos", "m.vazakopoulos@cosmote-evalue.gr", "Rome", Nationality.ITALIAN));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        try{
            customers.add(new CustomerBusiness(7L, "Thomas Karavasilis", "t.karavasilis@ote.gr", "Athens", Nationality.GREEK));
        } catch (CustomerEmailException e){
            System.out.println(e.getMessage());
        }
        return customers;
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

    public static void  mostTicketAndCostCustomer(List<Customer> customers, List<Ticket> ticketList) {
        Customer mostTicketsCustomer = null;
        Customer mostExpensesCustomer = null;
        int mostTickets = 0;
        double mostExpenses = 0.0;

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

        for (Customer customer : customers) {
            double tempExpenses = 0.0;
            for (Ticket ticket : ticketList) {
                if (customer.getId() == ticket.getCustomer().getId()) {
                    tempExpenses = tempExpenses + ticket.getPaymentAmount();
                }
            }
            if (tempExpenses > mostExpenses) {
                mostExpenses = tempExpenses;
                mostExpensesCustomer = customer;
            }
        }

        System.out.println("The customer with the most tickets is: " + mostTicketsCustomer.getName() +
                " with a total of " + mostTickets + " tickets");
        System.out.println("The customer with the most expenses is: " + mostExpensesCustomer.getName()
                + " with a total of " + mostExpenses + " euros");
    }
}
