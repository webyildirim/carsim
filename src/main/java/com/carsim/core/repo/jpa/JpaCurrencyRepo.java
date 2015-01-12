package com.carsim.core.repo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Currency;
import com.carsim.core.model.filter.CurrencyFilter;
import com.carsim.core.repo.CurrencyRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaCurrencyRepo implements CurrencyRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaCurrencyRepo() {
    	dao=new MainDao();
	}

    @Override
    public Currency findCurrency(Long id) {
    	Currency entity=new Currency();
    	entity.setId(id);    	
        return (Currency) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Currency deleteCurrency(Long id) throws Exception {
    	Currency entity = findCurrency(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Currency updateCurrency(Long id, Currency entity) throws Exception {
    	entity.setId(id);
    	entity=(Currency) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public Currency createCurrency(Currency entity) throws Exception {
        return (Currency) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public Currency findByName(String name) {
    	Currency entity=new Currency();
    	entity.setName(name);
    	return (Currency) dao.findObjectByFilter(manager, new CurrencyFilter(entity));
    }
}
