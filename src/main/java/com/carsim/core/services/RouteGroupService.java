package com.carsim.core.services;

import com.carsim.core.model.entities.RouteGroup;
import com.carsim.core.services.util.RouteList;

/**
 * Created by webyildirim on 6/28/14.
 */
public interface RouteGroupService {

    public RouteList findAllRoutes(Long account); // findRoutes all associated routeGroup entries
    public RouteGroup findRouteGroup(Long id);
    public RouteGroup deleteRouteGroup(Long id) throws Exception; 
}
