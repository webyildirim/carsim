package com.carsim.core.repo;


import java.util.Collection;
import java.util.List;

import com.carsim.core.model.entities.ServiceCategory;

/**
 * Created by webyildirim.
 */
public interface ServiceCategoryRepo {

	public Collection<ServiceCategory> findAll();
	
    public ServiceCategory findServiceCategory(Long id);

    public ServiceCategory deleteService(Long id) throws Exception;

    public ServiceCategory updateServiceCategory(Long id, ServiceCategory entity) throws Exception;

    public ServiceCategory createService(ServiceCategory entity) throws Exception;
 
    public Collection<ServiceCategory> findByName(String name);

    public List<ServiceCategory> findByDependentCategory(Long categoryId);

}
