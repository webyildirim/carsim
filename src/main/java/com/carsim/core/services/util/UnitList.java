package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.Unit;

/**
 * Created by webyildirim.
 */
public class UnitList {
    private List<Unit> entities = new ArrayList<Unit>();
    private Long unitGroupId;

    public UnitList(Long countryId, List<Unit> entities) {
        this.unitGroupId = countryId;
        this.entities = entities;
    }

    public List<Unit> getEntities() {
        return entities;
    }

    public void setEntities(List<Unit> entities) {
        this.entities = entities;
    }

    public Long getUnitGroupId() {
        return unitGroupId;
    }

    public void setUnitGroupId(Long unitGroupId) {
        this.unitGroupId = unitGroupId;
    }
}
