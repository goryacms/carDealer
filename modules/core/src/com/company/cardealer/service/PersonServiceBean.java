package com.company.cardealer.service;

import com.company.cardealer.entity.CarPurchaseRequest;
import com.company.cardealer.entity.Person;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(PersonService.NAME)
public class PersonServiceBean implements PersonService {
    @Inject
    private DataManager dataManager;

    @Override
    public Integer getCountDocs(UUID id) {
        return dataManager
                //.load(Person.class)
                .load(CarPurchaseRequest.class)
                //.query("select p.carPurchaseRequest from cardealer$Person p where p.person.id = :idParam")
                .query("select p from cardealer$CarPurchaseRequest p where p.person.id = :idParam")
                .parameter("idParam", id)
                .view("carPurchaseRequest-view")
                //.view("person-view")
                .list().size();
    }
}