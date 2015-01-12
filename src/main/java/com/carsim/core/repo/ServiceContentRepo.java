package com.carsim.core.repo;


import java.util.List;

import com.carsim.core.model.entities.ServiceContent;

/**
 * Created by webyildirim.
 */
public interface ServiceContentRepo {

    public ServiceContent findServiceContent(Long id);

    public ServiceContent deleteServiceContent(Long id) throws Exception;

    public ServiceContent updateServiceContent(Long id, ServiceContent entity) throws Exception;

    public ServiceContent createServiceContent(ServiceContent entity) throws Exception;

    public List<ServiceContent> findByService(Long cityId);
}
