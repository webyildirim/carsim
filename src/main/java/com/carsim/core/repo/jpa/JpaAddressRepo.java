package com.carsim.core.repo.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Address;
import com.carsim.core.repo.AddressRepo;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/9/14.
 */
@Repository
public class JpaAddressRepo implements AddressRepo {

    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaAddressRepo() {
    	dao=new MainDao();
	}

    @Override
    public Address findAddress(Long id) {
    	Address entity=new Address();
    	entity.setId(id);    	
        return (Address) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Address deleteAddress(Long id) throws Exception {
    	Address entity = findAddress(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Address updateAddress(Long id, Address entity) throws Exception {
    	entity.setId(id);
    	entity=(Address) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public Address createAddress(Address entity) throws Exception {
        return (Address) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public Address findAddressByCompany(Long companyId) {
        Query query = manager.createQuery("SELECT c.address from Company c where c.id=?1");
        query.setParameter(1, companyId);
        return (Address) query.getSingleResult();
    }
}
