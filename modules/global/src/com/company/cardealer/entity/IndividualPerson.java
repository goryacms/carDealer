package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity(name = "cardealer$IndividualPerson")
public class IndividualPerson extends Person {
    private static final long serialVersionUID = 3534930297712073619L;

    @Column(name = "NAME_AND_LAST_NAME")
    protected String nameAndLastName;

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }


}