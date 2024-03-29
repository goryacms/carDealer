package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Table(name = "CARDEALER_LEGAL_PERSON")
@Entity(name = "cardealer$LegalPerson")
@NamePattern("%s|name")
public class LegalPerson extends Person {
    private static final long serialVersionUID = 6086781293023962913L;

    @Column(name = "NAME", length = 75)
    protected String name;

    @Lob
    @Column(name = "INN_AND_ADDRESS")
    protected String innAndAddress;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setInnAndAddress(String innAndAddress) {
        this.innAndAddress = innAndAddress;
    }

    public String getInnAndAddress() {
        return innAndAddress;
    }


}