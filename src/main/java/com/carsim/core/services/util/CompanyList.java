package com.carsim.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.carsim.core.model.entities.Company;

/**
 * Created by webyildirim on 7/22/14.
 */
public class CompanyList {

    private List<Company> entities = new ArrayList<Company>();

    public CompanyList(List<Company> entities) {
        this.entities = entities;
    }

    public List<Company> getEntities() {
        return entities;
    }

    public void setEntities(List<Company> entities) {
        this.entities = entities;
    }
}
