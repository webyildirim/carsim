package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.City;
import com.carsim.core.repo.CityRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaCityRepo implements CityRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaCityRepo() {
    	dao=new MainDao();
	}

    @Override
    public City findCity(Long id) {
    	City entity=new City();
    	entity.setId(id);    	
        return (City) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public City deleteCity(Long id) throws Exception {
    	City entity = findCity(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public City updateCity(Long id, City entity) throws Exception {
    	entity.setId(id);
    	entity=(City) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public City createCity(City entity) throws Exception {
        return (City) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<City> findByCountry(Long countryId) {
        Query query = manager.createQuery("SELECT c.cities FROM Country c WHERE c.id=?1");
        query.setParameter(1, countryId);
        return query.getResultList();
    }
}
