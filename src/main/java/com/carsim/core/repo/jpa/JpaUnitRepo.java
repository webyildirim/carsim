package com.carsim.core.repo.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Unit;
import com.carsim.core.model.filter.UnitFilter;
import com.carsim.core.repo.UnitRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaUnitRepo implements UnitRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaUnitRepo() {
    	dao=new MainDao();
	}

    @Override
    public Unit findUnit(Long id) {
    	Unit entity=new Unit();
    	entity.setId(id);    	
        return (Unit) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Unit deleteUnit(Long id) throws Exception {
    	Unit entity = findUnit(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Unit updateUnit(Long id, Unit entity) throws Exception {
    	entity.setId(id);
    	entity=(Unit) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public Unit createUnit(Unit entity) throws Exception {
        return (Unit) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public Collection<Unit> findByCode(String name) {
    	Unit entity=new Unit();
    	entity.setName(name);
    	return dao.findByFilter(manager, new UnitFilter(entity));
    }

    @Override
    public Collection<Unit> findByUnitGroup(Long unitGroupId) {
        Query query = manager.createQuery("SELECT ug.units FROM UnitGroup ug WHERE ug.id=?1");
        query.setParameter(1, unitGroupId);
        return query.getResultList();
    }
}
