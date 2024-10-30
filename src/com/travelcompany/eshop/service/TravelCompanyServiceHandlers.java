package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.CustomerBusiness;
import com.travelcompany.eshop.domain.CustomerIndividual;
import com.travelcompany.eshop.domain.Itinerary;
import com.travelcompany.eshop.enumeration.Airline;
import com.travelcompany.eshop.enumeration.AirportCode;
import com.travelcompany.eshop.enumeration.Nationality;
import com.travelcompany.eshop.exception.ItineraryAirportCodeException;

import java.util.ArrayList;
import java.util.List;

public class TravelCompanyServiceHandlers {


    public static List<Customer> loadCustomers() {

        List<Customer> customers = List.of(
                new CustomerBusiness(1L, "Dimitrios Paschalis", "d.paschalis@cosmote-evalue.gr", "Athens", Nationality.GREEK),
                new CustomerIndividual(2L, "Yiota Plati", "p.plati@cosmote-evalue.gr", "Athens", Nationality.FRENCH),
                new CustomerBusiness(3L, "Dimitrios Zachos", "d.zachos@ote.gr", "Milan", Nationality.ITALIAN),
                new CustomerIndividual(4L, "Theodora Vasiladioti", "t.vasiladioti@travelcompany.com", "Thessaloniki", Nationality.GREEK),
                new CustomerBusiness(5L, "Spyros Farantos", "s.farantos@cosmote-evalue.gr", "Lyon", Nationality.FRENCH),
                new CustomerIndividual(6L, "Michael Vazakopoulos", "m.vazakopoulos@cosmote-evalue.gr", "Rome", Nationality.ITALIAN),
                new CustomerBusiness(7L, "Thomas Karavasilis", "t.karavasilis@ote.gr", "Athens", Nationality.GREEK));
        return customers;
    }

    public static List<Itinerary> loadItineraries() {
        //Simulate file loading
        List<Itinerary> itineraries = new ArrayList<>();
        try{
        itineraries.add(new Itinerary(1L, AirportCode.ATH, AirportCode.PAR, "22/02/2022 13:35", Airline.SKYLINES, 300));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
        itineraries.add(new Itinerary(2L, AirportCode.ATH, AirportCode.LON, "22/02/2022 13:40", Airline.SKYLINES, 420));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try {
            itineraries.add(new Itinerary(3L, AirportCode.ATH, AirportCode.AMS, "22/02/2022 13:45", Airline.SKYLINES, 280));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
        itineraries.add(new Itinerary(4L, AirportCode.ATH, AirportCode.FRA, "22/02/2022 14:20", Airline.SKYLINES, 310));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
        itineraries.add(new Itinerary(5L, AirportCode.ATH, AirportCode.DUB, "22/02/2022 14:35", Airline.SKYLINES, 880));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
        itineraries.add(new Itinerary(6L, AirportCode.ATH, AirportCode.DUB, "22/02/2022 14:55", Airline.SKYLINES, 770));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
        itineraries.add(new Itinerary(7L, AirportCode.ATH, AirportCode.MEX, "22/02/2022 16:00", Airline.SKYLINES, 1020));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
            itineraries.add(new Itinerary(8L, AirportCode.MEX, AirportCode.MEX, "22/02/2022 16:00", Airline.SKYLINES, 1020));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        try{
            itineraries.add(new Itinerary(8L, AirportCode.ATH, AirportCode.SKG, "22/02/2022 16:00", Airline.SKYLINES, 1020));
        }catch (ItineraryAirportCodeException e){
            System.out.println(e.getMessage());
        }
        return itineraries;
    }
}
