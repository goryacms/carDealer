package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "CARDEALER_PROC_ATTACHMENT")
@Entity(name = "cardealer$ProcAttachment")
public class ProcAttachment extends StandardEntity {
    private static final long serialVersionUID = -3622382682926872990L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_PURCHASE_REQUEST_ID")
    protected CarPurchaseRequest carPurchaseRequest;

    public void setCarPurchaseRequest(CarPurchaseRequest carPurchaseRequest) {
        this.carPurchaseRequest = carPurchaseRequest;
    }

    public CarPurchaseRequest getCarPurchaseRequest() {
        return carPurchaseRequest;
    }


}