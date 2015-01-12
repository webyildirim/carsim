package com.carsim.core.repo;

import java.util.List;

import com.carsim.core.model.entities.Account;
import com.carsim.core.model.entities.CompanyUser;

/**
 * Created by webyildirim.
 */
public interface CompanyUserRepo {

	public List<CompanyUser> findAll();

	public CompanyUser findCompanyUser(Long id);

	public Account findCompanyUserByName(String name);

	public Account createCompanyUser(CompanyUser data) throws Exception;

	public Account deleteCompanyUser(Long id) throws Exception;
}
