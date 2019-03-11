package com.company.cardealer.web.automaker;

import com.company.cardealer.entity.Automaker;
import com.company.cardealer.entity.Country;
import com.company.cardealer.service.ContryService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.TextField;

import javax.inject.Inject;
import javax.inject.Named;

public class AutomakerEdit extends AbstractEditor<Automaker> {

    @Named("fieldGroup.country")
    protected Field country;

    @Named("fieldGroup.code")
    protected TextField code;

    @Inject
    private ContryService countryService;
//
//    @Override
//    protected void postInit() {
//        super.postInit();
//
//        automakerDs.addItemChangeListener(e -> {
//            if(ofNullable(e.getItem()).isPresent()) {
//                Country countryVal = countryService.getDefaultCountry();
//                if(ofNullable(countryVal).isPresent()) {
//                    country.setValue(countryVal);
//                    e.getItem().setCountry(countryVal);
//                }
//            }
//        });
//
//    }

    @Override
    protected void initNewItem(Automaker item) {
        super.initNewItem(item);
        Country countryVal = countryService.getDefaultCountry();
        item.setCountry(countryVal);
    }

}