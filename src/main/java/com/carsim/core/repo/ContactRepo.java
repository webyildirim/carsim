package com.carsim.core.repo;

import java.util.Collection;
import java.util.List;

import com.carsim.core.model.entities.Contact;

/**
 * Created by webyildirim.
 */
public interface ContactRepo {

	public List<Contact> findAll();

	public Contact findContact(Long id);

	public Collection<Contact> findByCompany(Long id);
}
