package com.carsim.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsim.core.model.entities.Address;
import com.carsim.core.model.entities.BlogEntry;
import com.carsim.core.repo.AddressRepo;
import com.carsim.core.repo.BlogEntryRepo;
import com.carsim.core.services.AddressService;
import com.carsim.core.services.BlogEntryService;

/**
 * Created by webyildirim on 7/10/14.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo repo;

    @Override
    public Address findAddress(Long id) {
        return repo.findAddress(id);
    }

    @Override
    public Address deleteAddress(Long id) throws Exception {
        return repo.deleteAddress(id);
    }

    @Override
    public Address updateAddress(Long id, Address data) throws Exception {
        return repo.updateAddress(id, data);
    }
}
