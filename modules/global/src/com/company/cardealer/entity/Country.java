package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CARDEALER_COUNTRY")
@Entity(name = "cardealer$Country")
public class Country extends StandardEntity {
    private static final long serialVersionUID = -2146676005873192731L;

    @Column(name = "NAME", length = 100)
    protected String name;

    @Column(name = "CODE", length = 50)
    protected String code;

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


}