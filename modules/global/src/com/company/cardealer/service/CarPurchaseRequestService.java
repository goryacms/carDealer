package com.company.cardealer.service;


import java.math.BigDecimal;

public interface CarPurchaseRequestService {
    String NAME = "cardealer_CarPurchaseRequestService";

    BigDecimal getTaxRate(BigDecimal amount);
}