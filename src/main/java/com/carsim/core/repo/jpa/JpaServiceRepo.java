package com.carsim.core.repo.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Service;
import com.carsim.core.model.filter.ServiceFilter;
import com.carsim.core.repo.ServiceRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaServiceRepo implements ServiceRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaServiceRepo() {
    	dao=new MainDao();
	}

    @Override
    public Collection<Service> findAll() {
        return dao.getEntityList(manager, new Service());
    }
    
    @Override
    public Service findService(Long id) {
    	BaseEntity entity=new Service();
    	entity.setId(id);    	
        return (Service) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Service deleteService(Long id) throws Exception {
    	Service entity = findService(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Service updateService(Long id, Service entity) throws Exception {
    	entity.setId(id);
    	entity= (Service)dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public Service createService(Service entity) throws Exception {
        return (Service) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<Service> findByCompany(Long companyId) {
        Query query = manager.createQuery("SELECT s FROM Service s WHERE s.company.id=?1");
        query.setParameter(1, companyId);
        return query.getResultList();
    }

    @Override
    public List<Service> findByCategory(Long categoryId) {
        Query query = manager.createQuery("SELECT s FROM Service s WHERE s.category.id=?1");
        query.setParameter(1, categoryId);
        return query.getResultList();
    }

    @Override
    public Collection<Service> findByName(String name) {
    	Service entity=new Service();
    	entity.setName(name);
    	return dao.findByFilter(manager, new ServiceFilter(entity));
    }

    @Override
    public Collection<Service> findByCode(String code) {
    	Service entity=new Service();
    	entity.setCode(code);
    	return dao.findByFilter(manager, new ServiceFilter(entity));
    }
}
