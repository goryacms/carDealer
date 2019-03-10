package com.company.cardealer.service;

import com.company.cardealer.entity.Country;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(ContryService.NAME)
public class ContryServiceBean implements ContryService {

    @Inject
    private DataManager dataManager;

    @Override
    public Country getDefaultCountry() {
        return dataManager.load(Country.class)
                .query("select p from cardealer$Country p where p.code = :codeParam")
                .parameter("codeParam", "ru")
                .view("country-view")
                .one();

    }
}