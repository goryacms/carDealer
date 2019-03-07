package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@NamePattern("%s|name")
@Table(name = "CARDEALER_EQUIPMENT")
@Entity(name = "cardealer$Equipment")
public class Equipment extends StandardEntity {
    private static final long serialVersionUID = 4054378228918419369L;

    @Column(name = "NAME", length = 50)
    protected String name;

    @Column(name = "COST")
    protected BigDecimal cost;

    @Column(name = "CAR_TYPE")
    protected Integer carType;

    @Column(name = "NOTE")
    protected String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_MODEL_ID")
    protected CarModel carModel;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "equipment")
    protected Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }


    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCarType(CarType carType) {
        this.carType = carType == null ? null : carType.getId();
    }

    public CarType getCarType() {
        return carType == null ? null : CarType.fromId(carType);
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }


}