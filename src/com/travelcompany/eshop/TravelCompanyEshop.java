package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.enumeration.PaymentMethod;
import com.travelcompany.eshop.exception.CustomerEmailException;
import com.travelcompany.eshop.exception.TicketIssuingException;
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
        try {
            ticketService.buyTicket(customers.get(0), itineraries.get(5), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(0), itineraries.get(0), PaymentMethod.CASH, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(2), itineraries.get(1), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(3), itineraries.get(3), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(5), itineraries.get(4), PaymentMethod.CASH, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(3), itineraries.get(6), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(new CustomerBusiness(9L, "Who Am I?", "nobody@gmail.com", "Athens", Nationality.ITALIAN), itineraries.get(6), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(3), new Itinerary(9L, AirportCode.ATH, AirportCode.MEX, "22/02/2022 16:00", Airline.SKYLINES, 1020), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try {
            ticketService.buyTicket(customers.get(7), itineraries.get(6), PaymentMethod.CREDIT_CARD, customers, itineraries);
        }catch (TicketIssuingException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        List<Ticket> ticketList = ticketService.getTicketList();
        System.out.println();
        for (Ticket ticket : ticketList){
            System.out.println(ticket);
        }

        // Εκτύπωση με τα συνολικά εισιτήρια και τα κόστη για κάθε πελάτη
//        totalTicketsPerCustomer(customers, ticketList);

        // Λίστα με τα δρομολόγια από τις αναχωρήσεις και για τους προορισμούς.
//       itinerariesPerAirportCode(itineraries, AirportCode.ATH);
//        itinerariesPerAirportCode(itineraries, AirportCode.MEX);
//        itinerariesPerAirportCode(itineraries, AirportCode.AMS);
//        itinerariesPerAirportCode(itineraries, AirportCode.PAR);
//        itinerariesPerAirportCode(itineraries, AirportCode.LON);
//        itinerariesPerAirportCode(itineraries, AirportCode.DUB);
//        itinerariesPerAirportCode(itineraries, AirportCode.FRA);

        // Ο πελάτης με τα περισσότερα εισιτήρια και ο πελάτης με τα περισσότερα έξοδα
//        mostTicketAndCostCustomer(customers, ticketList);


        // Οι πελάτες χωρίς εισιτήρια
//        noTicketCustomers(ticketList, customers);
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

    public static void itinerariesPerAirportCode(List<Itinerary> itineraryList, AirportCode airportCode){
        int count = 0;
        System.out.println("List with departures from: " + airportCode);
        for (Itinerary itinerary: itineraryList){
            if (airportCode == itinerary.getDepartureAirportCode()){
                System.out.println(itinerary);
                count ++;
            }
        }
        if (count == 0) System.out.println("There are no Departures");
        count = 0;
        System.out.println("List with destinations for: " + airportCode);
        for (Itinerary itinerary: itineraryList){
            if (airportCode == itinerary.getDestinationAirportCode()){
                System.out.println(itinerary);
                count++;
            }
        }
        if (count == 0) System.out.println("There are no Destinations");
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
