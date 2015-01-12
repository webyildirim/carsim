package com.carsim.core.repo;


import java.util.Collection;
import java.util.List;

import com.carsim.core.model.entities.Service;

/**
 * Created by webyildirim.
 */
public interface ServiceRepo {

	public Collection<Service> findAll();
	
    public Service findService(Long id);

    public Service deleteService(Long id) throws Exception;

    public Service updateService(Long id, Service entity) throws Exception;

    public Service createService(Service entity) throws Exception;
 
    public List<Service> findByCompany(Long companyId);

    public List<Service> findByCategory(Long categoryId);

    public Collection<Service> findByName(String name);

    public Collection<Service> findByCode(String code);

}
