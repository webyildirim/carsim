package com.carsim.core.model.filter;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carsim.core.model.entities.Country;
import com.structure.BaseFilter;

public class CountryFilter extends BaseFilter
{
    public CountryFilter(Object object)
    {
        super(object);
    }

    @Override
    public Query createQuery(EntityManager manager)
    {
        Country country = (Country)object;
        StringBuilder queryString = new StringBuilder("\nFROM \n");
        queryString.append(country.getEntityName()).append(" c WHERE 1=1\n");

        if (!isNullOrEmpty(country.getCode()))
            queryString.append("AND c.code=:code \n");
        if (!isNullOrEmpty(country.getName()))
            queryString.append("AND lower(c.name) like :name \n");

        Query query = manager.createQuery(queryString.toString());
        if (!isNullOrEmpty(country.getCode()))
            query.setParameter("code", country.getCode());
        if (!isNullOrEmpty(country.getName()))
            query.setParameter("name", country.getName().toLowerCase());

        return query;
    }
}
