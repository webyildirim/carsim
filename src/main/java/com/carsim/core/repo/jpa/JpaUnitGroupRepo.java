package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.UnitGroup;
import com.carsim.core.repo.UnitGroupRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaUnitGroupRepo implements UnitGroupRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaUnitGroupRepo() {
    	dao=new MainDao();
	}

    @Override
    public UnitGroup findUnitGroup(Long id) {
    	UnitGroup entity=new UnitGroup();
    	entity.setId(id);    	
        return (UnitGroup) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public UnitGroup deleteUnitGroup(Long id) throws Exception {
    	UnitGroup entity = findUnitGroup(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public UnitGroup updateUnitGroup(Long id, UnitGroup entity) throws Exception {
    	entity.setId(id);
    	entity=(UnitGroup) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public UnitGroup createUnitGroup(UnitGroup entity) throws Exception {
        return (UnitGroup) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<UnitGroup> findByName(String name) {
        Query query = manager.createQuery("SELECT ug FROM UnitGroup ug WHERE lower(ug.name) like :?1");
        query.setParameter(1, name.toLowerCase());
        return query.getResultList();
    }

}
