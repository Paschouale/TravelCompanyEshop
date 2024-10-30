package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.enumeration.PaymentMethod;
import com.travelcompany.eshop.exception.TicketIssuingException;
import com.travelcompany.eshop.service.*;

import java.util.List;

public class TravelCompanyEshop {
    public static void main(String[] args) {
        System.out.println();

        // Δημιουργία για τα 3 services
        CustomerService customerService = new CustomerServiceImpl();
        ItineraryService itineraryService = new ItineraryServiceImpl();
        TicketService ticketService = new TicketServiceImpl();

        // Καταχώρηση πελατών στη λίστα
        customerService.addAll(CustomerServiceHandler.loadCustomers());
        List<Customer> customers = customerService.getCustomerList();
        System.out.println();

        // Εκτύπωση των πελατών
        for (Customer customer : customers){
            System.out.println(customer);
        }
        System.out.println();

        // Καταχώρηση δρομολογίων στη λίστα
        itineraryService.addAll(ItineraryServiceHandler.loadItineraries());
        List<Itinerary> itineraries = itineraryService.getItineraryList();
        System.out.println();

        // Εκτύπωση των δρομολογίων
        for (Itinerary itinerary : itineraries){
            System.out.println(itinerary);
        }
        System.out.println();

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

        // Εκτύπωση των εισιτηρίων
        for (Ticket ticket : ticketList){
            System.out.println(ticket);
        }
        System.out.println();

        // Εκτύπωση με τα συνολικά εισιτήρια και τα κόστη για κάθε πελάτη
        CustomerServiceHandler.totalTicketsPerCustomer(customers, ticketList);
        System.out.println();

        // Λίστα με τα δρομολόγια από τις αναχωρήσεις και για τους προορισμούς.
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.ATH);
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.MEX);
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.AMS);
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.PAR);
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.LON);
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.DUB);
        ItineraryServiceHandler.itinerariesPerAirportCode(itineraries, AirportCode.FRA);

        // Ο πελάτης με τα περισσότερα εισιτήρια και ο πελάτης με τα περισσότερα έξοδα
        CustomerServiceHandler.mostTicketAndCostCustomer(customers, ticketList);
        System.out.println();

        // Οι πελάτες χωρίς εισιτήρια
        TicketServiceHandler.noTicketCustomers(ticketList, customers);
    }
}
