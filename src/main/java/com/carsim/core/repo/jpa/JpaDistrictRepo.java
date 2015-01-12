package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.District;
import com.carsim.core.repo.DistrictRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaDistrictRepo implements DistrictRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaDistrictRepo() {
    	dao=new MainDao();
	}

    @Override
    public District findDistrict(Long id) {
    	BaseEntity entity=new District();
    	entity.setId(id);    	
        return (District) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public District deleteDistrict(Long id) throws Exception {
    	District entity = findDistrict(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public District updateDistrict(Long id, District entity) throws Exception {
    	entity.setId(id);
    	entity=(District) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public District createDistrict(District entity) throws Exception {
        return (District) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<District> findByCity(Long cityId) {
        Query query = manager.createQuery("SELECT c.districts FROM City c WHERE c.id=?1");
        query.setParameter(1, cityId);
        return query.getResultList();
    }
}
