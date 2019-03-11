package com.company.cardealer.core;

import com.company.cardealer.entity.CarPurchaseRequest;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

@Component("extdealer_ApprovalHelper")
public class ApprovalHelper {
    @Inject
    private Persistence persistence;

    public void updateState(UUID entityId, String state) {
        try (Transaction tx = persistence.getTransaction()){
            CarPurchaseRequest carPurchaseRequest = persistence.getEntityManager().find(CarPurchaseRequest.class, entityId);
            if (carPurchaseRequest != null) {
                carPurchaseRequest.setState(state);
            }
            tx.commit();
        }
    }
}