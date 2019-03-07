package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.OneToOne;

@NamePattern("%s|name")
@Table(name = "CARDEALER_CAR_MODEL")
@Entity(name = "cardealer$CarModel")
public class CarModel extends StandardEntity {
    private static final long serialVersionUID = 9191900640403130922L;

    @Column(name = "NAME", length = 50)
    protected String name;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "carModel")
    protected List<Equipment> equipment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTOMAKER_ID")
    protected Automaker automaker;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "carModel")
    protected Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }


    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAutomaker(Automaker automaker) {
        this.automaker = automaker;
    }

    public Automaker getAutomaker() {
        return automaker;
    }


}