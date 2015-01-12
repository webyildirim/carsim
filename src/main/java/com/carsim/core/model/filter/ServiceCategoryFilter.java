package com.carsim.core.model.filter;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.carsim.core.model.entities.ServiceCategory;
import com.structure.BaseFilter;

public class ServiceCategoryFilter  extends BaseFilter
{
    public ServiceCategoryFilter(Object object)
    {
        super(object);
    }

    @Override
    public Query createQuery(EntityManager manager)
    {
    	ServiceCategory entity = (ServiceCategory)object;
        StringBuilder queryString = new StringBuilder("\nFROM \n");
        queryString.append(entity.getEntityName()).append(" s WHERE 1=1\n");

        if (!isNullOrEmpty(entity.getName()))
            queryString.append("AND lower(s.name) like :name \n");
        if (!isNull(entity.getDependentCategory()))
            queryString.append("AND dependentCategory=:dependentCategory \n");
        
        Query query = manager.createQuery(queryString.toString());

        if (!isNullOrEmpty(entity.getName()))
            query.setParameter("name", entity.getName().toLowerCase());
        if (!isNull(entity.getDependentCategory()))
            query.setParameter("dependentCategory", entity.getDependentCategory());
        
        return query;
    }
    
}