package com.travelcompany.eshop;

import com.travelcompany.eshop.domain.Customer;
import com.travelcompany.eshop.enumeration.Category;
import com.travelcompany.eshop.enumeration.Nationality;

public class TravelCompanyEshop {
    public static void main(String[] args) {
        Customer dimitrios = new Customer(1L, "Dimitrios Paschalis", "d.paschalis@cosmote-evalue.gr", "Athens", Nationality.GREEK, Category.BUSINESS);
        Customer yiota = new Customer(2L, "Yiota Plati", "p.plati@cosmote-evalue.gr", "Athens", Nationality.FRENCH, Category.INDIVIDUAL);
        Customer mitsos = new Customer(3L, "Dimitrios Zachos", "d.zachos@ote.gr", "Milan", Nationality.ITALIAN, Category.BUSINESS);
        Customer dora = new Customer(4L, "Theodora Vasiladioti", "t.vasiladioti@cosmote-evalue.gr", "Thessaloniki", Nationality.GREEK, Category.INDIVIDUAL);
        Customer spyros = new Customer(5L, "Spyros Farantos", "s.farantos@cosmote-evalue.gr", "Lyon", Nationality.FRENCH, Category.BUSINESS);
        Customer michael = new Customer(6L, "Michael Vazakopoulos", "m.vazakopoulos@cosmote-evalue.gr", "Rome", Nationality.ITALIAN, Category.INDIVIDUAL);
        Customer thomas = new Customer(7L, "Thomas Karavasilis", "t.karavasilis@ote.gr", "Athens", Nationality.GREEK, Category.BUSINESS);
    }
}
