package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;
import com.carsim.core.model.entities.City;

/**
 * Created by webyildirim.
 */
public class CityList {
    private List<City> entities = new ArrayList<City>();
    private Long countryId;

    public CityList(Long countryId, List<City> entities) {
        this.countryId = countryId;
        this.entities = entities;
    }

    public List<City> getEntities() {
        return entities;
    }

    public void setEntities(List<City> entities) {
        this.entities = entities;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
