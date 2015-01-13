package com.carsim.core.services;

import com.carsim.core.model.entities.Address;

/**
 * Created by webyildirim on 6/27/14.
 */
public interface AddressService {
    public Address findAddress(Long id); 
    public Address deleteAddress(Long id) throws Exception; 

    public Address updateAddress(Long id, Address data) throws Exception;

}
