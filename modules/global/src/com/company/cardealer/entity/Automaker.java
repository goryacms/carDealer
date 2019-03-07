package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CARDEALER_AUTOMAKER")
@Entity(name = "cardealer$Automaker")
public class Automaker extends StandardEntity {
    private static final long serialVersionUID = -5965317474588653518L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @NotNull
    @Column(name = "CODE", nullable = false, unique = true, length = 50)
    protected String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    protected Country country;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }


}