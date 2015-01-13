package com.carsim.core.repo.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Contact;
import com.carsim.core.model.entities.CustomerUser;
import com.carsim.core.model.entities.DeliveryAddress;
import com.carsim.core.model.filter.CustomerUserFilter;
import com.carsim.core.repo.CustomerUserRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/9/14.
 */
@Repository
public class JpaCustomerUserRepo implements CustomerUserRepo {

    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaCustomerUserRepo() {
    	dao=new MainDao();
	}

    @Override
    public CustomerUser findCustomerUser(Long id) {
    	BaseEntity entity=new CustomerUser();
    	entity.setId(id);    	
        return (CustomerUser) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public CustomerUser findCustomerUserByName(String name) {
    	CustomerUser entity=new CustomerUser();
    	entity.setName(name);
    	return (CustomerUser) dao.findObjectByFilter(manager, new CustomerUserFilter(entity));
    }

    @Override
    public CustomerUser createCustomerUser(CustomerUser data) throws Exception {
    	return (CustomerUser) dao.saveOrUpdateEntity(manager, data);
    }

    @Override
    public CustomerUser deleteCustomerUser(Long id) throws Exception {
    	CustomerUser entity=findCustomerUser(id);
    	if(entity!=null)
    		dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Collection<DeliveryAddress> findDeliveryAddress(Long customerUserId) throws Exception {
    	CustomerUser entity=findCustomerUser(customerUserId);
    	if(entity!=null)
    		return entity.getDeliveryAddresses();
    	else
    		return new ArrayList();
    }
}
