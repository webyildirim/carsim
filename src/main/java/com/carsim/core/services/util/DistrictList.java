package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.District;

/**
 * Created by webyildirim.
 */
public class DistrictList {
    private List<District> entities = new ArrayList<District>();
    private Long cityId;

    public DistrictList(Long cityId, List<District> entities) {
        this.cityId = cityId;
        this.entities = entities;
    }

    public List<District> getEntities() {
        return entities;
    }

    public void setEntities(List<District> entities) {
        this.entities = entities;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
