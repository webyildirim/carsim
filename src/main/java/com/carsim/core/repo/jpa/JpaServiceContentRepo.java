package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.ServiceContent;
import com.carsim.core.repo.ServiceContentRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaServiceContentRepo implements ServiceContentRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaServiceContentRepo() {
    	dao=new MainDao();
	}

    @Override
    public ServiceContent findServiceContent(Long id) {
    	BaseEntity entity=new ServiceContent();
    	entity.setId(id);    	
        return (ServiceContent) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public ServiceContent deleteServiceContent(Long id) throws Exception {
    	ServiceContent entity = findServiceContent(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public ServiceContent updateServiceContent(Long id, ServiceContent entity) throws Exception {
    	entity.setId(id);
    	entity=(ServiceContent) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public ServiceContent createServiceContent(ServiceContent entity) throws Exception {
        return (ServiceContent) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<ServiceContent> findByService(Long serviceId) {
        Query query = manager.createQuery("SELECT s.serviceContents FROM Service s WHERE s.id=?1");
        query.setParameter(1, serviceId);
        return query.getResultList();
    }
}
