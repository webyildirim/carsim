package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.ServicePrice;

/**
 * Created by webyildirim.
 */
public class ServicePriceList {
    private List<ServicePrice> entities = new ArrayList<ServicePrice>();
    private Long serviceId;

    public ServicePriceList(Long serviceId, List<ServicePrice> entities) {
        this.serviceId = serviceId;
        this.entities = entities;
    }

    public List<ServicePrice> getEntities() {
        return entities;
    }

    public void setEntities(List<ServicePrice> entities) {
        this.entities = entities;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
