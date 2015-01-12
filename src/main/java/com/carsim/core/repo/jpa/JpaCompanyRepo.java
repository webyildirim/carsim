package com.carsim.core.repo.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Company;
import com.carsim.core.model.filter.CompanyFilter;
import com.carsim.core.repo.CompanyRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/9/14.
 */
@Repository
public class JpaCompanyRepo implements CompanyRepo {

    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaCompanyRepo() {
    	dao=new MainDao();
	}

	@Override
    public List<Company> findAllCompanies() {
        return (List<Company>) dao.getEntityList(manager, new Company());
    }

    @Override
    public Company findCompany(Long id) {
    	BaseEntity entity=new Company();
    	entity.setId(id);    	
        return (Company) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Company findCompanyByName(String name) {
    	Company entity=new Company();
    	entity.setName(name);
    	return (Company) dao.findObjectByFilter(manager, new CompanyFilter(entity));
    }

    @Override
    public Collection<Company> findCompaniesByName(String name) {
    	Company entity=new Company();
    	entity.setName(name);
    	return dao.findByFilter(manager, new CompanyFilter(entity));
    }

    @Override
    public Company createCompany(Company data) throws Exception {
    	return (Company) dao.saveOrUpdateEntity(manager, data);
    }

    @Override
    public Company deleteCompany(Long id) throws Exception {
    	Company entity=findCompany(id);
    	if(entity!=null)
    		dao.removeEntity(manager, entity);
        return entity;
    }
}
