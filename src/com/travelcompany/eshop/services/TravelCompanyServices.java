package com.travelcompany.eshop.services;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.domain.Ticket;

public interface TravelCompanyServices {

    Ticket selectItinerary(Customer customer, Itinerary itinerary); //Creates Ticket for Customer
    double ticketPrice(Ticket ticket);

}
