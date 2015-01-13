package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.ServicePrice;

/**
 * Created by webyildirim.
 */
public class ServiceList {
    private List<ServicePrice> entities = new ArrayList<ServicePrice>();
    private Long companyId;

    public ServiceList(Long companyId, List<ServicePrice> entities) {
        this.companyId = companyId;
        this.entities = entities;
    }

    public List<ServicePrice> getEntities() {
        return entities;
    }

    public void setEntities(List<ServicePrice> entities) {
        this.entities = entities;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
