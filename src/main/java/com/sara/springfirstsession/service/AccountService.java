package com.sara.springfirstsession.service;

import com.sara.springfirstsession.model.Account;

public interface AccountService {

    Account createAccount(Account account) throws Exception;

    Account findOneAccount(Long id) throws  Exception;
}
