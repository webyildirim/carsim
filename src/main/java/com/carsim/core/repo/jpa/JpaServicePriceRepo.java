package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.ServicePrice;
import com.carsim.core.repo.ServicePriceRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaServicePriceRepo implements ServicePriceRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaServicePriceRepo() {
    	dao=new MainDao();
	}

    @Override
    public ServicePrice findServicePrice(Long id) {
    	BaseEntity entity=new ServicePrice();
    	entity.setId(id);    	
        return (ServicePrice) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public ServicePrice deleteServicePrice(Long id) throws Exception {
    	ServicePrice entity = findServicePrice(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public ServicePrice updateServicePrice(Long id, ServicePrice entity) throws Exception {
    	entity.setId(id);
    	entity=(ServicePrice) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public ServicePrice createServicePrice(ServicePrice entity) throws Exception {
        return (ServicePrice) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<ServicePrice> findByService(Long serviceId) {
        Query query = manager.createQuery("SELECT s.servicePrices FROM Service s WHERE s.id=?1");
        query.setParameter(1, serviceId);
        return query.getResultList();
    }
}
