package com.carsim.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsim.core.model.entities.City;
import com.carsim.core.model.entities.Country;
import com.carsim.core.repo.CityRepo;
import com.carsim.core.repo.CountryRepo;
import com.carsim.core.services.CityService;
import com.carsim.core.services.exceptions.EntityNotFoundException;
import com.carsim.core.services.util.BlogList;
import com.carsim.core.services.util.CityList;

/**
 * Created by webyildirim on 7/10/14.
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepo cityRepo;

	@Autowired
	private CountryRepo countryRepo;

	@Override
	public City findCity(Long id) {
		return cityRepo.findCity(id);
	}

	@Override
	public City createCity(Long countryId, City data) throws Exception {
		Country country = countryRepo.findCountry(countryId);
		if (country == null) {
			throw new EntityNotFoundException();
		}
		data.setCountry(country);
		data = cityRepo.createCity(data);
		return data;
	}

	@Override
	public CityList findByCountryId(Long countryId) {
		Country country = countryRepo.findCountry(countryId);
		if (country == null) {
			throw new EntityNotFoundException();
		}
		return new CityList(countryId, cityRepo.findByCountry(countryId));
	}

	@Override
	public City updateCity(Long id, City data) throws Exception {
		return cityRepo.updateCity(id, data);
	}
}
