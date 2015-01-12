package com.carsim.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsim.core.model.entities.Route;
import com.carsim.core.model.entities.RouteGroup;
import com.carsim.core.repo.RouteGroupRepo;
import com.carsim.core.repo.RouteRepo;
import com.carsim.core.services.RouteGroupService;
import com.carsim.core.services.exceptions.EntityNotFoundException;
import com.carsim.core.services.util.RouteList;

/**
 * Created by webyildirim on 7/10/14.
 */
@Service
@Transactional
public class RouteGroupServiceImpl implements RouteGroupService {

    @Autowired
    private RouteGroupRepo routeGroupRepo;

    @Autowired
    private RouteRepo routeRepo;
    
    @Override
    public RouteList findAllRoutes(Long routeGroupId) {
    	RouteGroup routeGroup = routeGroupRepo.findRouteGroup(routeGroupId);
        if(routeGroup == null)
        {
            throw new EntityNotFoundException();
        }
        return new RouteList(routeGroupId, (List<Route>) routeGroup.getRoutes());
    }

    @Override
    public RouteGroup findRouteGroup(Long id) {
        return routeGroupRepo.findRouteGroup(id);
    }

	@Override
	public RouteGroup deleteRouteGroup(Long id) throws Exception {
		return routeGroupRepo.deleteRouteGroup(id);
	}
}
