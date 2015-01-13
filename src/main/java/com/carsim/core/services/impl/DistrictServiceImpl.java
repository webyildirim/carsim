package com.carsim.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsim.core.model.entities.City;
import com.carsim.core.model.entities.District;
import com.carsim.core.repo.CityRepo;
import com.carsim.core.repo.DistrictRepo;
import com.carsim.core.services.DistrictService;
import com.carsim.core.services.exceptions.EntityNotFoundException;
import com.carsim.core.services.util.DistrictList;

/**
 * Created by webyildirim on 7/10/14.
 */
@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictRepo districtRepo;

	@Autowired
	private CityRepo cityRepo;

	@Override
	public District findDistrict(Long id) {
		return districtRepo.findDistrict(id);
	}

	@Override
	public District createDistrict(Long cityId, District data) throws Exception {
		City city = cityRepo.findCity(cityId);
		if (city == null) {
			throw new EntityNotFoundException();
		}
		data.setCity(city);
		data = districtRepo.createDistrict(data);
		return data;
	}

	@Override
	public DistrictList findByCityId(Long cityId) {
		City city = cityRepo.findCity(cityId);
		if (city == null) {
			throw new EntityNotFoundException();
		}
		return new DistrictList(cityId, districtRepo.findByCity(cityId));
	}

	@Override
	public District updateDistrict(Long id, District data) throws Exception {
		return districtRepo.updateDistrict(id, data);
	}
}
