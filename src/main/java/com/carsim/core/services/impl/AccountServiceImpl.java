package com.carsim.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carsim.core.model.entities.Account;
import com.carsim.core.model.entities.Blog;
import com.carsim.core.repo.AccountRepo;
import com.carsim.core.repo.BlogRepo;
import com.carsim.core.repo.RouteGroupRepo;
import com.carsim.core.services.AccountService;
import com.carsim.core.services.exceptions.AccountDoesNotExistException;
import com.carsim.core.services.exceptions.AccountExistsException;
import com.carsim.core.services.exceptions.EntityAlreadyExistsException;
import com.carsim.core.services.util.AccountList;
import com.carsim.core.services.util.BlogList;
import com.carsim.core.services.util.RouteGroupList;

/**
 * Created by webyildirim on 7/10/14.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private RouteGroupRepo routeGroupRepo;

    @Override
    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data) throws Exception {
        Account account = accountRepo.findAccountByName(data.getName());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

        if(blogSameTitle != null)
        {
            throw new EntityAlreadyExistsException("Blog zaten mevcut");
        }

        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepo.createBlog(data);

        createdBlog.setOwner(account);

        return createdBlog;
    }

    @Override
    public BlogList findBlogsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    @Override
    public AccountList findAllAccounts() {
        return new AccountList(accountRepo.findAllAccounts());
    }

    @Override
    public Account findByAccountName(String name) {
        return accountRepo.findAccountByName(name);
    }

    @Override
    public RouteGroupList findRouteGroupsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new RouteGroupList(routeGroupRepo.findRouteGroupsByAccount(accountId));
    }
}
