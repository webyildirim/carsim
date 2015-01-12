package com.carsim.core.repo;

import com.carsim.core.model.entities.Account;

import java.util.List;

/**
 * Created by webyildirim.
 */
public interface AccountRepo {
    public List<Account> findAllAccounts();
    public Account findAccount(Long id);
    public Account findAccountByName(String name);
    public Account createAccount(Account data) throws Exception;
    public Account deleteAccount(Long id) throws Exception;
}
