package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Table(name = "CARDEALER_PERSON")
@Entity(name = "cardealer$Person")
public class Person extends StandardEntity {
    private static final long serialVersionUID = -2847989299873257393L;

    @Column(name = "PHONE", length = 20)
    protected String phone;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    protected CarPurchaseRequest carPurchaseRequest;

    public void setCarPurchaseRequest(CarPurchaseRequest carPurchaseRequest) {
        this.carPurchaseRequest = carPurchaseRequest;
    }

    public CarPurchaseRequest getCarPurchaseRequest() {
        return carPurchaseRequest;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


}