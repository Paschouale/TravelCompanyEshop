package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.*;
import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.services.TravelCompanyServices;
import com.travelcompany.eshop.services.TravelCompanyServicesHandlers;
import com.travelcompany.eshop.services.TravelCompanyServicesImpl;

public class TravelCompanyEshop {
    public static void main(String[] args) {

        Customer[] customers = TravelCompanyServicesHandlers.loadCustomers();
        Itinerary[] itineraries = TravelCompanyServicesHandlers.loadItineraries();

        TravelCompanyServicesImpl services = new TravelCompanyServicesImpl();

        Ticket ticket = services.selectItinerary(customers[1], itineraries[5]);
        System.out.println(ticket.getPaymentAmount());
    }
}
