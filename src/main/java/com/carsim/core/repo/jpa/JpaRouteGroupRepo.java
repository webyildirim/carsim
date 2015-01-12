package com.carsim.core.repo.jpa;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Account;
import com.carsim.core.model.entities.BlogEntry;
import com.carsim.core.model.entities.RouteGroup;
import com.carsim.core.repo.RouteGroupRepo;
import com.structure.BaseEntity;
import com.structure.BaseFilter;
import com.structure.persistence.MainDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

/**
 * Created by webyildirim on 7/10/14.
 */
@Repository
public class JpaRouteGroupRepo implements RouteGroupRepo {
    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaRouteGroupRepo() {
    	dao=new MainDao();
	}
    
    @Override
    public RouteGroup createRouteGroup(RouteGroup data) throws Exception {
        return (RouteGroup) dao.saveOrUpdateEntity(manager, data);
    }

    @Override
    public RouteGroup findRouteGroup(Long id) {
    	BaseEntity entity=new RouteGroup();
    	entity.setId(id);    	
        return (RouteGroup) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public RouteGroup findRouteGroupByFilter(BaseFilter baseFilter, String queryMethod) {
    	return (RouteGroup) dao.findObjectByFilter(manager, baseFilter);
    }

    @Override
    public List<RouteGroup> findRouteGroupsByAccount(Long accountId) {
        Query query = manager.createQuery("SELECT rg from RouteGroup gr where rg.owner.id=?1");
        query.setParameter(1, accountId);
        return query.getResultList();
    }

    @Override
    public RouteGroup deleteRouteGroup(Long id) throws Exception {
    	RouteGroup routeGroup=findRouteGroup(id);
    	if(routeGroup!=null)
    		dao.removeEntity(manager, routeGroup);
        return routeGroup;
    }
}
