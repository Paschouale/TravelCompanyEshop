package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;

public class Itinerary {
    private Long id;
    private AirportCode departureAirportCode;
    private AirportCode destinationAirportCode;
    private String departureDate;
    private Airline airline;
    double basicPrice;
}
