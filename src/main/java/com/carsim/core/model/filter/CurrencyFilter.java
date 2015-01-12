package com.carsim.core.model.filter;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carsim.core.model.entities.Currency;
import com.structure.BaseFilter;

public class CurrencyFilter extends BaseFilter
{
    public CurrencyFilter(Object object)
    {
        super(object);
    }

    @Override
    public Query createQuery(EntityManager manager)
    {
        Currency currency = (Currency)object;
        StringBuilder queryString = new StringBuilder("\nFROM \n");
        queryString.append(currency.getEntityName()).append(" c WHERE 1=1\n");

        if (!isNullOrEmpty(currency.getName()))
            queryString.append("AND c.name=:name \n");

        Query query = manager.createQuery(queryString.toString());
        if (!isNullOrEmpty(currency.getName()))
            query.setParameter("name", currency.getName());

        return query;
    }
}