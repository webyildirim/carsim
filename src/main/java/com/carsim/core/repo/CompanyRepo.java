package com.carsim.core.repo;

import java.util.Collection;
import java.util.List;

import com.carsim.core.model.entities.Company;

/**
 * Created by webyildirim.
 */
public interface CompanyRepo {

	public List<Company> findAllCompanies();

	public Company findCompany(Long id);

	public Company createCompany(Company data) throws Exception;

	public Company deleteCompany(Long id) throws Exception;

	public Company findCompanyByName(String name);

	public Collection<Company> findCompaniesByName(String name);
}
