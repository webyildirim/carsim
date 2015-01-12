package com.carsim.core.model.filter;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.carsim.core.model.entities.CustomerUser;
import com.structure.BaseFilter;

public class CustomerUserFilter  extends BaseFilter
{
    public CustomerUserFilter(Object object)
    {
        super(object);
    }

    @Override
    public Query createQuery(EntityManager manager)
    {
    	CustomerUser entity = (CustomerUser)object;
        StringBuilder queryString = new StringBuilder("\nFROM \n");
        queryString.append(entity.getEntityName()).append(" u WHERE 1=1\n");

        if (!isNullOrEmpty(entity.getFirstName()))
            queryString.append("AND lower(u.firstName) like :firstName \n");
        if (!isNullOrEmpty(entity.getMiddleName()))
            queryString.append("AND lower(u.middleName) like :middleName \n");
        if (!isNullOrEmpty(entity.getLastName()))
            queryString.append("AND lower(u.lastName) like :lastName \n");
        if (!isNullOrEmpty(entity.getName()))
            queryString.append("AND lower(u.name) like :name \n");
        
        Query query = manager.createQuery(queryString.toString());
        
        if (!isNullOrEmpty(entity.getFirstName()))
            query.setParameter("firstName", entity.getFirstName().toLowerCase());
        if (!isNullOrEmpty(entity.getMiddleName()))
            query.setParameter("middleName", entity.getMiddleName().toLowerCase());
        if (!isNullOrEmpty(entity.getLastName()))
            query.setParameter("lastName", entity.getLastName().toLowerCase());
        if (!isNullOrEmpty(entity.getName()))
            query.setParameter("name", entity.getName().toLowerCase());
        
        return query;
    }
    
}