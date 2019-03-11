package com.company.cardealer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;

@Table(name = "CARDEALER_PERSON")
@Entity(name = "cardealer$Person")
public class Person extends StandardEntity {
    private static final long serialVersionUID = -2847989299873257393L;

    @MetaProperty(datatype = "phone")
    @Column(name = "PHONE", length = 20)
    protected String phone;

    @OneToMany(mappedBy = "person")
    protected List<CarPurchaseRequest> carPurchaseRequest;

    public List<CarPurchaseRequest> getCarPurchaseRequest() {
        return carPurchaseRequest;
    }

    public void setCarPurchaseRequest(List<CarPurchaseRequest> carPurchaseRequest) {
        this.carPurchaseRequest = carPurchaseRequest;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


}