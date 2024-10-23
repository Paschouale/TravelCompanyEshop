package com.travelcompany.eshop.service;

import com.travelcompany.eshop.domain.Itinerary;

import java.util.List;

public interface ItineraryService {
    void add(Itinerary itinerary);
    void addAll(List<Itinerary> itineraries);
    Itinerary getById(Long id);
    List<Itinerary> getItineraryList();
}
