package com.carsim.core.repo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.carsim.core.model.entities.Account;
import com.carsim.core.model.entities.CompanyUser;
import com.carsim.core.model.filter.AccountFilter;
import com.carsim.core.model.filter.CompanyUserFilter;
import com.carsim.core.repo.AccountRepo;
import com.carsim.core.repo.CompanyUserRepo;
import com.structure.BaseEntity;
import com.structure.persistence.MainDao;

/**
 * Created by webyildirim on 7/9/14.
 */
@Repository
public class JpaCompanyUserRepo implements CompanyUserRepo {

    @PersistenceContext
    private EntityManager manager;
    
    private MainDao dao=null;

    public JpaCompanyUserRepo() {
    	dao=new MainDao();
	}

	@Override
    public List<CompanyUser> findAll() {
        return (List<CompanyUser>) dao.getEntityList(manager, new CompanyUser());
    }

    @Override
    public CompanyUser findCompanyUser(Long id) {
    	BaseEntity entity=new CompanyUser();
    	entity.setId(id);    	
        return (CompanyUser) dao.findByPrimaryKey(manager, entity);
    }

    @Override
    public Account findCompanyUserByName(String name) {
    	CompanyUser entity=new CompanyUser();
    	entity.setName(name);
    	return (CompanyUser) dao.findObjectByFilter(manager, new CompanyUserFilter(entity));
    }

    @Override
    public Account createCompanyUser(CompanyUser data) throws Exception {
    	return (Account) dao.saveOrUpdateEntity(manager, data);
    }

    @Override
    public Account deleteCompanyUser(Long id) throws Exception {
    	CompanyUser entity=findCompanyUser(id);
    	if(entity!=null)
    		dao.removeEntity(manager, entity);
        return entity;
    }
}
