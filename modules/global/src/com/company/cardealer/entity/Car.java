package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NumberFormat;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import java.math.BigDecimal;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CARDEALER_CAR")
@Entity(name = "cardealer$Car")
public class Car extends StandardEntity {
    private static final long serialVersionUID = -8659356275441087873L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTOMAKER_ID")
    protected Automaker automaker;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_MODEL_ID")
    protected CarModel carModel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EQUIPMENT_ID")
    protected Equipment equipment;

    @Column(name = "NAME")
    protected String name;

    @MetaProperty(datatype = "year")
    @Column(name = "ISSUE_YEAR")
    protected Integer issueYear;

    @Column(name = "CAR_COST")
    protected BigDecimal carCost;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
    protected CarPurchaseRequest carPurchaseRequest;

    public void setCarPurchaseRequest(CarPurchaseRequest carPurchaseRequest) {
        this.carPurchaseRequest = carPurchaseRequest;
    }

    public CarPurchaseRequest getCarPurchaseRequest() {
        return carPurchaseRequest;
    }


    public void setCarCost(BigDecimal carCost) {
        this.carCost = carCost;
    }

    public BigDecimal getCarCost() {
        return carCost;
    }


    public void setAutomaker(Automaker automaker) {
        this.automaker = automaker;
    }

    public Automaker getAutomaker() {
        return automaker;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }

    public Integer getIssueYear() {
        return issueYear;
    }


}