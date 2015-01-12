package com.carsim.core.model.filter;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carsim.core.model.entities.Service;
import com.structure.BaseFilter;

public class ServiceFilter  extends BaseFilter
{
    public ServiceFilter(Object object)
    {
        super(object);
    }

    @Override
    public Query createQuery(EntityManager manager)
    {
    	Service entity = (Service)object;
        StringBuilder queryString = new StringBuilder("\nFROM \n");
        queryString.append(entity.getEntityName()).append(" s WHERE 1=1\n");

        if (!isNullOrEmpty(entity.getCode()))
            queryString.append("AND lower(s.code)=:code \n");
        if (!isNullOrEmpty(entity.getName()))
            queryString.append("AND lower(s.name) like :name \n");
        
        Query query = manager.createQuery(queryString.toString());
        
        if (!isNullOrEmpty(entity.getCode()))
            query.setParameter("code", entity.getCode().toLowerCase());
        if (!isNullOrEmpty(entity.getName()))
            query.setParameter("name", entity.getName().toLowerCase());
        
        return query;
    }
    
}