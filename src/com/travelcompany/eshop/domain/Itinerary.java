package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;

public class Itinerary {
    private Long id;
    private AirportCode departureAirportCode;
    private AirportCode destinationAirportCode;
    private String departureDate;
    private Airline airline;
    private double basicPrice;

    public Itinerary(Long id, AirportCode departureAirportCode, AirportCode destinationAirportCode, String departureDate, Airline airline, double basicPrice) {
        this.id = id;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.airline = airline;
        this.basicPrice = basicPrice;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public Airline getAirline() {
        return airline;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public AirportCode getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public AirportCode getDepartureAirportCode() {
        return departureAirportCode;
    }

    public Long getId() {
        return id;
    }
}
