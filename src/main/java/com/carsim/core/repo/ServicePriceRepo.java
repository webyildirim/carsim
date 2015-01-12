package com.carsim.core.repo;


import java.util.List;

import com.carsim.core.model.entities.ServicePrice;

/**
 * Created by webyildirim.
 */
public interface ServicePriceRepo {

    public ServicePrice findServicePrice(Long id);

    public ServicePrice deleteServicePrice(Long id) throws Exception;

    public ServicePrice updateServicePrice(Long id, ServicePrice entity) throws Exception;

    public ServicePrice createServicePrice(ServicePrice entity) throws Exception;

    public List<ServicePrice> findByService(Long cityId);
}
