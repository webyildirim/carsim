package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.Currency;

/**
 * Created by webyildirim on 7/22/14.
 */
public class CurrencyList {

    private List<Currency> entities = new ArrayList<Currency>();

    public CurrencyList(List<Currency> entities) {
        this.entities = entities;
    }

    public List<Currency> getEntities() {
        return entities;
    }

    public void setEntities(List<Currency> entities) {
        this.entities = entities;
    }
}
