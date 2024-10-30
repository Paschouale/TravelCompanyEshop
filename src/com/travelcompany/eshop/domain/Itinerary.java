package com.travelcompany.eshop.domain;

import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.exception.ItineraryAirportCodeException;

public class Itinerary {
    private Long id;
    private AirportCode departureAirportCode;
    private AirportCode destinationAirportCode;
    private String departureDate;
    private Airline airline;
    private double basicPrice;

    public Itinerary(Long id, AirportCode departureAirportCode, AirportCode destinationAirportCode, String departureDate, Airline airline, double basicPrice) {
        if (departureAirportCode != AirportCode.ATH){
            throw new ItineraryAirportCodeException("For Itinerary with id: " + id + " the Departure Airport " + departureAirportCode + " doesn't have a flight");
        }
        if (!(destinationAirportCode == AirportCode.AMS || destinationAirportCode == AirportCode.MEX || destinationAirportCode == AirportCode.LON
                || destinationAirportCode == AirportCode.FRA || destinationAirportCode == AirportCode.DUB || destinationAirportCode == AirportCode.PAR)){
            throw new ItineraryAirportCodeException("For Itinerary with id: " + id + " the Destination Airport " + destinationAirportCode + " doesn't have a flight");
        }
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

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", departureAirportCode=" + departureAirportCode +
                ", destinationAirportCode=" + destinationAirportCode +
                ", departureDate='" + departureDate + '\'' +
                ", airline=" + airline +
                ", basicPrice=" + basicPrice +
                '}';
    }
}
