package com.carsim.core.repo;


import java.util.Collection;

import com.carsim.core.model.entities.Country;

/**
 * Created by webyildirim.
 */
public interface CountryRepo {


    public Country findCountry(Long id) ;

    public Country deleteCountry(Long id) throws Exception;

    public Country updateCity(Long id, Country entity) throws Exception;
    
    public Country createCountry(Country entity) throws Exception;

    public Collection<Country> findByName(String name);
}
