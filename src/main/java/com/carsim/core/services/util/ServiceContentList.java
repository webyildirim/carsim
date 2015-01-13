package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.ServiceContent;

/**
 * Created by webyildirim.
 */
public class ServiceContentList {
    private List<ServiceContent> entities = new ArrayList<ServiceContent>();
    private Long serviceId;

    public ServiceContentList(Long serviceId, List<ServiceContent> entities) {
        this.serviceId = serviceId;
        this.entities = entities;
    }

    public List<ServiceContent> getEntities() {
        return entities;
    }

    public void setEntities(List<ServiceContent> entities) {
        this.entities = entities;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
