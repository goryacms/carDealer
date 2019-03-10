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
import java.util.List;
import javax.persistence.OneToMany;

@Table(name = "CARDEALER_CAR_PURCHASE_REQUEST")
@Entity(name = "cardealer$CarPurchaseRequest")
public class CarPurchaseRequest extends StandardEntity {
    private static final long serialVersionUID = 5031112687601480787L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    protected Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    protected Person person;

    @Column(name = "CAR_PAID")
    protected Boolean carPaid;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @Column(name = "TAX")
    protected BigDecimal tax;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    protected ExtUser manager;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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