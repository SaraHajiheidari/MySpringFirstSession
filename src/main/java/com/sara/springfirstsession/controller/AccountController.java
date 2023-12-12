package com.sara.springfirstsession.controller;

import com.sara.springfirstsession.model.Account;
import com.sara.springfirstsession.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Account")
@Controller

public class AccountController {


    @Autowired
    private AccountService accountService;



    @PostMapping(value = "createAccount")
    public ResponseEntity openAccount(@RequestBody Account account) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.accountService.createAccount(account));
    }

    @GetMapping(value = "SuchenById/{id}")
    public ResponseEntity<Account> suchenById(@PathVariable Long id) throws  Exception{
        return new ResponseEntity<>(accountService.findOneAccount(id), HttpStatus.OK);
    }

    @GetMapping(value = "account-by-balance/{balance}")
    public ResponseEntity<Account> findByBalance(@PathVariable Integer balance) throws Exception{
        return new ResponseEntity<>(accountService.findAccountByBalance(balance) ,HttpStatus.OK);
    }

}
