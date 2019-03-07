package com.company.cardealer.entity;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import com.haulmont.cuba.core.entity.annotation.Extends;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.chile.core.annotations.NamePattern;

import java.math.BigDecimal;

@NamePattern("%s|firstName")
@Extends(User.class)
@Entity(name = "cardealer$ExtUser")
public class ExtUser extends User {
    private static final long serialVersionUID = -6122467086042578856L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    protected Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }


}