package com.company.cardealer.service;

import com.haulmont.cuba.core.global.Configuration;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

@Service(CarPurchaseRequestService.NAME)
public class CarPurchaseRequestServiceBean implements CarPurchaseRequestService {

    @Inject
    protected Configuration configuration;

    @Override
    public BigDecimal getTaxRate(BigDecimal amount) {
        BigDecimal taxRate = configuration.getConfig(CardealerConfig.class).getTaxRate();
        return amount.multiply(taxRate);
    }
}