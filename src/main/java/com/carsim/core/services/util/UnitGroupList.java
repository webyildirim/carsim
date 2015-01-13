package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.UnitGroup;

/**
 * Created by webyildirim on 7/22/14.
 */
public class UnitGroupList {

    private List<UnitGroup> entities = new ArrayList<UnitGroup>();

    public UnitGroupList(List<UnitGroup> entities) {
        this.entities = entities;
    }

    public List<UnitGroup> getEntities() {
        return entities;
    }

    public void setEntities(List<UnitGroup> entities) {
        this.entities = entities;
    }
}
