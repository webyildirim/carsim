package com.carsim.core.repo;


import java.util.List;

import com.carsim.core.model.entities.District;

/**
 * Created by webyildirim.
 */
public interface DistrictRepo {

    public District findDistrict(Long id);

    public District deleteDistrict(Long id) throws Exception;

    public District updateDistrict(Long id, District entity) throws Exception;

    public District createDistrict(District entity) throws Exception;

    public List<District> findByCity(Long cityId);
}
