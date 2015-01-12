package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Order;
import com.carsim.core.repo.OrderRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaOrderRepo implements OrderRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaOrderRepo() {
    	dao=new MainDao();
	}

    @Override
    public Order findOrder(Long id) {
    	BaseEntity entity=new Order();
    	entity.setId(id);    	
        return (Order) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Order deleteOrder(Long id) throws Exception {
    	Order entity = findOrder(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public Order updateOrder(Long id, Order entity) throws Exception {
    	entity.setId(id);
    	entity=(Order) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public Order createDistrict(Order entity) throws Exception {
        return (Order) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<Order> findByCompany(Long companyId) {
        Query query = manager.createQuery("SELECT o FROM Order o WHERE o.company.id=?1");
        query.setParameter(1, companyId);
        return query.getResultList();
    }

    @Override
    public List<Order> findByCompanyAndStatus(Long companyId, byte orderStatus) {
        Query query = manager.createQuery("SELECT o FROM Order o WHERE o.company.id=?1 AND o.status=?2");
        query.setParameter(1, companyId);
        query.setParameter(2, orderStatus);
        return query.getResultList();
    }

    @Override
    public List<Order> findByCustomerUserAndCompany(Long customerUserId, Long companyId) {
        Query query = manager.createQuery("SELECT o FROM Order o WHERE o.customer.id=?1 AND o.company.id=?2");
        query.setParameter(1, customerUserId);
        query.setParameter(2, companyId);
        return query.getResultList();
    }
}
