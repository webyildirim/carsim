package com.carsim.core.repo.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Address;
import com.carsim.core.model.entities.DeliveryAddress;
import com.carsim.core.repo.AddressRepo;
import com.carsim.core.repo.DeliveryAddressRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/9/14.
 */
@Repository
public class JpaDeliveryAddressRepo implements DeliveryAddressRepo {

    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaDeliveryAddressRepo() {
    	dao=new MainDao();
	}

    @Override
    public DeliveryAddress findDeliveryAddress(Long id) {
    	DeliveryAddress entity=new DeliveryAddress();
    	entity.setId(id);    	
        return (DeliveryAddress) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public DeliveryAddress deleteDeliveryAddress(Long id) throws Exception {
    	DeliveryAddress entity = findDeliveryAddress(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public DeliveryAddress updateDeliveryAddress(Long id, DeliveryAddress entity) throws Exception {
    	entity.setId(id);
    	entity=(DeliveryAddress) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public DeliveryAddress createDeliveryAddress(DeliveryAddress entity) throws Exception {
        return (DeliveryAddress) dao.saveOrUpdateEntity(manager, entity);
    }
}
