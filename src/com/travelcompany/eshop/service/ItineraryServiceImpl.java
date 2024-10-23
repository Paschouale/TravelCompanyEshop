package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.domain.Itinerary;

import java.util.ArrayList;
import java.util.List;

public class ItineraryServiceImpl implements ItineraryService{
    private List<Itinerary> itineraries = new ArrayList<>();

    @Override
    public void add(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    @Override
    public void addAll(List<Itinerary> itineraries) {
        this.itineraries.addAll(itineraries);
    }

    @Override
    public Itinerary getById(Long id) {
        for (Itinerary itinerary: itineraries){
            if (itinerary.getId().equals(id)){
                return itinerary;
            }
        }
        return null;
    }

    @Override
    public List<Itinerary> getItineraryList() {
        return itineraries;
    }
}
