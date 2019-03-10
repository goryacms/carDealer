package com.company.cardealer.service;


import com.company.cardealer.entity.Country;

public interface ContryService {
    String NAME = "cardealer_ContryService";

    Country getDefaultCountry();
}