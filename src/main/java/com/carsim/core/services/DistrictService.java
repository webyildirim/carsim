package com.carsim.core.services;

import com.carsim.core.model.entities.District;
import com.carsim.core.services.util.DistrictList;

/**
 * Created by webyildirim on 6/28/14.
 */
public interface DistrictService {

	public District findDistrict(Long id);

	public District createDistrict(Long cityId, District data) throws Exception;

	public District updateDistrict(Long id, District data) throws Exception;

	public DistrictList findByCityId(Long cityId);
}
