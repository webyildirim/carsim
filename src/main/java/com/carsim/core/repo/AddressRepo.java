package com.carsim.core.repo;


import com.carsim.core.model.entities.Address;

/**
 * Created by webyildirim.
 */
public interface AddressRepo {

    public Address findAddress(Long id);
    public Address deleteAddress(Long id) throws Exception;
    public Address updateAddress(Long id, Address entity) throws Exception;
    public Address createAddress(Address entity) throws Exception;
    public Address findAddressByCompany(Long companyId);
}
