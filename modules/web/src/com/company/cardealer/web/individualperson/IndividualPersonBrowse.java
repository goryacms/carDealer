package com.company.cardealer.web.individualperson;

import com.company.cardealer.entity.IndividualPerson;
import com.company.cardealer.service.PersonService;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;

import javax.inject.Inject;
import java.util.Map;

public class IndividualPersonBrowse extends AbstractLookup {
    @Inject
    private GroupTable<IndividualPerson> individualPersonsTable;

    @Inject
    private PersonService personService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        individualPersonsTable.addGeneratedColumn(
                getMessage("count"), entity -> {
                    Integer countDocs = personService.getCountDocs(entity.getId());
                    return new Table.PlainTextCell(countDocs.toString());
                }
        );
    }
}