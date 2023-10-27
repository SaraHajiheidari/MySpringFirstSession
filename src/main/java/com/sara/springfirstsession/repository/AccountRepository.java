package com.sara.springfirstsession.repository;

import com.sara.springfirstsession.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountRepository extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {
}
