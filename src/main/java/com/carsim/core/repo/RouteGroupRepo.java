package com.carsim.core.repo;

import java.util.List;

import com.carsim.core.model.entities.RouteGroup;
import com.structure.BaseFilter;

/**
 * Created by webyildirim on 7/10/14.
 */
public interface RouteGroupRepo {
    public RouteGroup createRouteGroup(RouteGroup data) throws Exception;
    public RouteGroup findRouteGroup(Long id);
    public RouteGroup deleteRouteGroup(Long id) throws Exception; 
    public RouteGroup findRouteGroupByFilter(BaseFilter filter, String queryMethod);
    public List<RouteGroup> findRouteGroupsByAccount(Long accountId);
}
