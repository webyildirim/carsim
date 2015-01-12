package com.carsim.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.carsim.core.services.util.AccountList;
import com.carsim.rest.mvc.AccountController;
import com.carsim.rest.resources.AccountListResource;
import com.carsim.rest.resources.AccountResource;

import java.util.List;

/**
 * Created by Chris on 7/22/14.
 */
public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {


    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
