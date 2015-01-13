package com.carsim.core.services;

import com.carsim.core.model.entities.City;
import com.carsim.core.services.util.CityList;

/**
 * Created by webyildirim on 6/28/14.
 */
public interface CityService {

	public City findCity(Long id);

	public City createCity(Long countryId, City data) throws Exception;

	public City updateCity(Long id, City data) throws Exception;

	public CityList findByCountryId(Long countryId);
}
