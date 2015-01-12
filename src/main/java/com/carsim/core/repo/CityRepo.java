package com.carsim.core.repo;


import java.util.List;

import com.carsim.core.model.entities.City;

/**
 * Created by webyildirim.
 */
public interface CityRepo {

    public City findCity(Long id) ;
    public City deleteCity(Long id) throws Exception ;
    public City updateCity(Long id, City entity) throws Exception;
    public City createCity(City entity) throws Exception ;
    public List<City> findByCountry(Long countryId);
}
