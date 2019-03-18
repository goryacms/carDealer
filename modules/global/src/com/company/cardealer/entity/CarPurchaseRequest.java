package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;

import java.util.List;
import javax.persistence.OneToMany;

@TrackEditScreenHistory
@Table(name = "CARDEALER_CAR_PURCHASE_REQUEST")
@Entity(name = "cardealer$CarPurchaseRequest")
public class CarPurchaseRequest extends StandardEntity {
    private static final long serialVersionUID = 5031112687601480787L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    protected Car car;

    @Column(name = "CAR_PAID")
    protected Boolean carPaid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INDIVIDUAL_PERSON_ID")
    protected IndividualPerson individualPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEGAL_PERSON_ID")
    protected LegalPerson legalPerson;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @Column(name = "TAX")
    protected BigDecimal tax;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    protected ExtUser manager;

    @Column(name = "STATE")
    protected String state;


    public void setIndividualPerson(IndividualPerson individualPerson) {
        this.individualPerson = individualPerson;
    }

    public IndividualPerson getIndividualPerson() {
        return individualPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }


    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }




    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCarPaid(Boolean carPaid) {
        this.carPaid = carPaid;
    }

    public Boolean getCarPaid() {
        return carPaid;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setManager(ExtUser manager) {
        this.manager = manager;
    }

    public ExtUser getManager() {
        return manager;
    }


}