package com.carsim.core.services;

import com.carsim.core.model.entities.Account;
import com.carsim.core.model.entities.Blog;
import com.carsim.core.services.util.AccountList;
import com.carsim.core.services.util.BlogList;
import com.carsim.core.services.util.RouteGroupList;

/**
 * Created by webyildirim on 6/28/14.
 */
public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data) throws Exception;
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
    
    public RouteGroupList findRouteGroupsByAccount(Long accountId);
}
