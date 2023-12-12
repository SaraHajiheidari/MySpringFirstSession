package com.sara.springfirstsession.repository;

import com.sara.springfirstsession.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {


    Optional<Account> findById(Long id);

    @Query ("select a from Account a where a.accountNumber =:accountNumber")
    Account findAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

    @Query ("select a from Account  a where a.balance >=:balance")
    Account findAccountByBalance(@Param("balance") Integer balance);



}


