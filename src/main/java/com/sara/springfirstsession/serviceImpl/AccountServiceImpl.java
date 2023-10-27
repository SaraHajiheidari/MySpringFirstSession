package com.sara.springfirstsession.serviceImpl;

import com.sara.springfirstsession.model.Account;
import com.sara.springfirstsession.repository.AccountRepository;
import com.sara.springfirstsession.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account createAccount(Account account) throws Exception {
        return accountRepository.save(account);
    }
}
