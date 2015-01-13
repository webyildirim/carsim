package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.ServiceCategory;

/**
 * Created by webyildirim on 7/22/14.
 */
public class ServiceCategoryList {

    private List<ServiceCategory> entities = new ArrayList<ServiceCategory>();

    public ServiceCategoryList(List<ServiceCategory> entities) {
        this.entities = entities;
    }

    public List<ServiceCategory> getEntities() {
        return entities;
    }

    public void setEntities(List<ServiceCategory> entities) {
        this.entities = entities;
    }
}
