package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.OrderDetail;
import com.carsim.core.repo.OrderDetailRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaOrderDetailRepo implements OrderDetailRepo{
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;
    
    public JpaOrderDetailRepo() {
    	dao=new MainDao();
	}

    @Override
    public OrderDetail findOrderDetail(Long id) {
    	BaseEntity entity=new OrderDetail();
    	entity.setId(id);    	
        return (OrderDetail) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public OrderDetail deleteOrderDetail(Long id) throws Exception {
    	OrderDetail entity = findOrderDetail(id);
        dao.removeEntity(manager, entity);
        return entity;
    }

    @Override
    public OrderDetail updateOrderDetail(Long id, OrderDetail entity) throws Exception {
    	entity.setId(id);
    	entity=(OrderDetail) dao.saveOrUpdateEntity(manager, entity);
        return entity;
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail entity) throws Exception {
        return (OrderDetail) dao.saveOrUpdateEntity(manager, entity);
    }

    @Override
    public List<OrderDetail> findByOrder(Long orderId) {
        Query query = manager.createQuery("SELECT o.details FROM Order o WHERE o.id=?1");
        query.setParameter(1, orderId);
        return query.getResultList();
    }
}
