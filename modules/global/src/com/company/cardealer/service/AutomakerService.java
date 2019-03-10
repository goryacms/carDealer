package com.company.cardealer.service;


import com.company.cardealer.entity.Automaker;

public interface AutomakerService {
    String NAME = "cardealer_AutomakerService";

    Integer getCarModelCount(Automaker entity);
}