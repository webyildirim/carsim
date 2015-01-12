package com.carsim.core.repo.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Service;
import com.carsim.core.model.entities.ServiceCategory;
import com.carsim.core.model.filter.ServiceCategoryFilter;
import com.carsim.core.model.filter.ServiceFilter;
import com.carsim.core.repo.ServiceCategoryRepo;
import com.carsim.core.repo.ServiceRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaServiceCategoryRepo implements ServiceCategoryRepo{
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaServiceCategoryRepo() {
    	dao=new MainDao();
	}

    @Override
    public Collection<ServiceCategory> findAll() {
        return dao.getEntityList(manager, new ServiceCategory());
    }
    
    @Override
    public ServiceCategory findServiceCategory(Long id) {
    	BaseEntity entity=new ServiceCategory();
    	entity.setId(id);    	
        return (ServiceCategory) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public ServiceCategory deleteService(Long id) throws Exception {
    	ServiceCategory entity = findServiceCategory(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public ServiceCategory updateServiceCategory(Long id, ServiceCategory entity) throws Exception {
    	entity.setId(id);
    	entity= (ServiceCategory)dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public ServiceCategory createService(ServiceCategory entity) throws Exception {
        return (ServiceCategory) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public Collection<ServiceCategory> findByName(String name) {
    	ServiceCategory entity=new ServiceCategory();
    	entity.setName(name);
    	return dao.findByFilter(manager, new ServiceCategoryFilter(entity));
    }

    @Override
    public List<ServiceCategory> findByDependentCategory(Long categoryId) {
        Query query = manager.createQuery("SELECT s FROM ServiceCategory s WHERE s.dependentCategory.id=?1");
        query.setParameter(1, categoryId);
        return query.getResultList();
    	
    }
}
