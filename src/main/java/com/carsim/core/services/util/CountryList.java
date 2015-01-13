package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.Country;

/**
 * Created by webyildirim on 7/22/14.
 */
public class CountryList {

    private List<Country> entities = new ArrayList<Country>();

    public CountryList(List<Country> entities) {
        this.entities = entities;
    }

    public List<Country> getAccounts() {
        return entities;
    }

    public void setAccounts(List<Country> entities) {
        this.entities = entities;
    }
}
