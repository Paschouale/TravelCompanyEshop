package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.exception.ItineraryAirportCodeException;

import java.util.ArrayList;
import java.util.List;

public class ItineraryServiceHandler {
    public static List<Itinerary> loadItineraries() {
        //Simulate file loading
        List<Itinerary> itineraries = new ArrayList<>();
        try {
            itineraries.add(new Itinerary(1L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35", Airline.SKYLINES, 300));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(2L, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40", Airline.SKYLINES, 420));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(3L, AirportCode.ATH, AirportCode.AMS, "22/02/2022 13:45", Airline.SKYLINES, 280));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(4L, AirportCode.ATH, AirportCode.FRA, "22/02/2022 14:20", Airline.SKYLINES, 310));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(5L, AirportCode.ATH, AirportCode.DUB, "22/02/2022 14:35", Airline.SKYLINES, 880));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(6L, AirportCode.ATH, AirportCode.DUB, "22/02/2022 14:55", Airline.SKYLINES, 770));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(7L, AirportCode.ATH, AirportCode.MEX, "22/02/2022 16:00", Airline.SKYLINES, 1020));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(8L, AirportCode.MEX, AirportCode.MEX, "22/02/2022 16:00", Airline.SKYLINES, 1020));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(9L, AirportCode.ATH, AirportCode.SKG, "22/02/2022 16:00", Airline.SKYLINES, 1020));
        } catch (ItineraryAirportCodeException e) {
            System.out.println(e.getMessage());
        }
        return itineraries;
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
        System.out.println();
        count = 0;
        System.out.println("List with destinations for: " + airportCode);
        for (Itinerary itinerary: itineraryList){
            if (airportCode == itinerary.getDestinationAirportCode()){
                System.out.println(itinerary);
                count++;
            }
        }
        if (count == 0) System.out.println("There are no Destinations");
        System.out.println();
    }
}
