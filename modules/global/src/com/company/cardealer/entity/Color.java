package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "CARDEALER_COLOR")
@Entity(name = "cardealer$Color")
public class Color extends StandardEntity {
    private static final long serialVersionUID = -1187334095187021830L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true, length = 15)
    protected String name;

    @NotNull
    @Column(name = "CODE", nullable = false, unique = true, length = 10)
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