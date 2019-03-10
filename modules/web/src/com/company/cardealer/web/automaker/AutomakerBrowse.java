package com.company.cardealer.web.automaker;

import com.company.cardealer.entity.Automaker;
import com.company.cardealer.service.AutomakerService;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class AutomakerBrowse extends AbstractLookup {

    @Inject
    protected GroupTable<Automaker> automakersTable;

    @Inject
    protected ComponentsFactory factory;

    @Inject
    protected AutomakerService automakerService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        automakersTable.addGeneratedColumn(
                getMessage("count"), entity -> {
                    Integer quantity = automakerService.getCarModelCount(entity);
                    return new Table.PlainTextCell(quantity.toString());
                });
    }

}