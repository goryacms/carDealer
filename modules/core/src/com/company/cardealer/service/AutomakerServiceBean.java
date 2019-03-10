package com.company.cardealer.service;

import com.company.cardealer.entity.Automaker;
import org.springframework.stereotype.Service;

@Service(AutomakerService.NAME)
public class AutomakerServiceBean implements AutomakerService {

    @Override
    public Integer getCarModelCount(Automaker entity) {
        return entity.getCarModel().size();
    }
}