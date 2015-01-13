package com.carsim.core.repo;

import com.carsim.core.model.entities.DeliveryAddress;

/**
 * Created by webyildirim.
 */
public interface DeliveryAddressRepo {

	public DeliveryAddress findDeliveryAddress(Long id);

	public DeliveryAddress deleteDeliveryAddress(Long id) throws Exception;

	public DeliveryAddress updateDeliveryAddress(Long id, DeliveryAddress entity) throws Exception;

	public DeliveryAddress createDeliveryAddress(DeliveryAddress entity) throws Exception;
}
