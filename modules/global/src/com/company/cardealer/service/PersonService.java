package com.company.cardealer.service;


import java.util.UUID;

public interface PersonService {
    String NAME = "cardealer_PersonService";

    Integer getCountDocs(UUID id);
}