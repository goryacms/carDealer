package com.company.cardealer.service;

import com.company.cardealer.entity.Country;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.security.global.UserSession;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service(ContryService.NAME)
public class ContryServiceBean implements ContryService {

    @Inject
    private DataManager dataManager;

    @Inject
    private Persistence persistence;

    @Override
    public Country getDefaultCountry() {
        Country result;
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            Query query = em.createQuery(
                    "select p from cardealer$Country p where p.code = 'ru'");
            result = (Country) query.getFirstResult();
            // commit transaction
            tx.commit();
        }
        return result;
    }
}