package com.carsim.core.model.filter;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carsim.core.model.entities.Unit;
import com.structure.BaseFilter;

public class UnitFilter  extends BaseFilter
{
    public UnitFilter(Object object)
    {
        super(object);
    }

    @Override
    public Query createQuery(EntityManager manager)
    {
    	Unit entity = (Unit)object;
        StringBuilder queryString = new StringBuilder("\nFROM \n");
        queryString.append(entity.getEntityName()).append(" u WHERE 1=1\n");

        if (!isNullOrEmpty(entity.getCode()))
            queryString.append("AND lower(u.code)=:code \n");
        if (!isNullOrEmpty(entity.getName()))
            queryString.append("AND lower(u.name) like :name \n");
        
        Query query = manager.createQuery(queryString.toString());
        
        if (!isNullOrEmpty(entity.getCode()))
            query.setParameter("code", entity.getCode().toLowerCase());
        if (!isNullOrEmpty(entity.getName()))
            query.setParameter("name", entity.getName().toLowerCase());
        
        return query;
    }
    
}