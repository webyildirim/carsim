package com.carsim.core.repo.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Country;
import com.carsim.core.model.filter.CountryFilter;
import com.carsim.core.repo.CountryRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaCountryRepo implements CountryRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaCountryRepo() {
    	dao=new MainDao();
	}

    @Override
    public Country findCountry(Long id) {
    	Country entity=new Country();
    	entity.setId(id);    	
        return (Country) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Country deleteCountry(Long id) throws Exception {
    	Country entity = findCountry(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Country updateCity(Long id, Country entity) throws Exception {
    	entity.setId(id);
    	entity=(Country) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public Country createCountry(Country entity) throws Exception {
        return (Country) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public Collection<Country> findByName(String name) {
    	Country entity=new Country();
    	entity.setName(name);
    	return dao.findByFilter(manager, new CountryFilter(entity));
    }
}
