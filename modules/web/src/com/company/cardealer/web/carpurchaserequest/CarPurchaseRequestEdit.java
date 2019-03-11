package com.company.cardealer.web.carpurchaserequest;

import com.company.cardealer.entity.CarPurchaseRequest;
import com.company.cardealer.service.CarPurchaseRequestService;
import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

public class CarPurchaseRequestEdit extends AbstractEditor<CarPurchaseRequest> {

    @Named("fieldGroup.tax")
    private TextField taxField;

    @Named("fieldGroup.amount")
    private TextField amountField;

    @Inject
    private CarPurchaseRequestService carPurchaseRequestService;

    @Override
    protected void postInit() {
        super.postInit();

        amountField.addValueChangeListener(it -> {
            BigDecimal amount = getItem().getAmount();
            BigDecimal resultTax = carPurchaseRequestService.getTaxRate(amount);
            taxField.setValue(resultTax);
            getItem().setTax(resultTax);
        });
    }
}