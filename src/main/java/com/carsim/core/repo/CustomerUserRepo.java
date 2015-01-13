package com.carsim.core.repo;

import java.util.Collection;

import com.carsim.core.model.entities.Contact;
import com.carsim.core.model.entities.CustomerUser;
import com.carsim.core.model.entities.DeliveryAddress;

/**
 * Created by webyildirim.
 */
public interface CustomerUserRepo {

    public CustomerUser findCustomerUser(Long id);

    public CustomerUser findCustomerUserByName(String name);

    public CustomerUser createCustomerUser(CustomerUser data) throws Exception;

    public CustomerUser deleteCustomerUser(Long id) throws Exception;
    
    public Collection<DeliveryAddress> findDeliveryAddress(Long customerUserId) throws Exception; 
}
