package com.carsim.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import com.carsim.core.model.entities.RouteGroup;

/**
 * Created by webyildirim on 6/30/14.
 */
public class RouteGroupResource extends ResourceSupport {

    private String title;

    private Long rid;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RouteGroup toRouteGroup() {
    	RouteGroup routeGroup = new RouteGroup();
    	routeGroup.setTitle(title);
        return routeGroup;
    }
}
