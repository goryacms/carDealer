package com.company.cardealer.web.car;

import com.company.cardealer.entity.CarModel;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.cardealer.entity.Car;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.UUID;

public class CarEdit extends AbstractEditor<Car> {
    @Named("fieldGroup.automaker")
    private PickerField automakerField;

    @Named("fieldGroup.carModel")
    private LookupPickerField carModelField;

    @Inject
    private CollectionDatasource<CarModel, UUID> carModelsDs;

    @Inject
    private Datasource<Car> carDs;

    @Override
    protected void postInit() {
        super.postInit();

        automakerField.addValueChangeListener(e -> {
            getItem().setCarCost(BigDecimal.valueOf(150.00));

            carModelsDs.refresh();
        });
    }
}