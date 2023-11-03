package com.sara.springfirstsession.service;

import com.sara.springfirstsession.dto.TransactionDto;

public interface TransactionService {

    Long transferMoney(TransactionDto transactionDto) throws Exception;

    Long withdrawMoney(TransactionDto transactionDto) throws Exception;

    Long depositMoney(TransactionDto transactionDto) throws Exception;
}
