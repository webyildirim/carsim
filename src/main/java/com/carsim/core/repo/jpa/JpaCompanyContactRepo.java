package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Contact;
import com.carsim.core.repo.ContactRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/9/14.
 */
@Repository
public class JpaCompanyContactRepo implements ContactRepo {

    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaCompanyContactRepo() {
    	dao=new MainDao();
	}

	@Override
    public List<Contact> findAll() {
        return (List<Contact>) dao.getEntityList(manager, new Contact());
    }

    @Override
    public Contact findContact(Long id) {
    	BaseEntity entity=new Contact();
    	entity.setId(id);    	
        return (Contact) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public List<Contact> findByCompany(Long id) {
        Query query = manager.createQuery("SELECT c.contacts FROM Company c WHERE c.id=?1");
        query.setParameter(1, id);
        return query.getResultList();
    }
}
