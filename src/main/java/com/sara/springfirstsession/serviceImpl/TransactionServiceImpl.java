package com.sara.springfirstsession.serviceImpl;

import com.sara.springfirstsession.dto.TransactionDto;
import com.sara.springfirstsession.model.Account;
import com.sara.springfirstsession.model.Transaction;
import com.sara.springfirstsession.repository.AccountRepository;
import com.sara.springfirstsession.repository.TransactionRepository;
import com.sara.springfirstsession.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TransactionServiceImpl implements TransactionService {


    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private TransactionRepository transactionRepository;



    @Override
    public Long transferMoney(TransactionDto transactionDto) throws Exception {
        if(transactionDto.getFromAccount() == null)
            throw new Exception("accountnummer absender ist nicht eingetragen!");

        Account fromAccount = accountRepository.findAccountByAccountNumber(transactionDto.getFromAccount());

        if(transactionDto.getToAccount() == null)
            throw new Exception("accountnummer ziel ist nicht eingetragen!");

        Account toAccount = accountRepository.findAccountByAccountNumber(transactionDto.getToAccount());

        Date currentDate = new Date();
        Transaction transaction = new Transaction();

        if(fromAccount.getBalance() != null && fromAccount.getBalance() > transactionDto.getTransferAmountMoney() -1)

            try{
                Integer fromBalance, toBalance;
                fromBalance = fromAccount.getBalance();
                toBalance = toAccount.getBalance();
                fromBalance -= transactionDto.getTransferAmountMoney();
                toBalance += transactionDto.getTransferAmountMoney();
                fromAccount.setBalance(fromBalance);
                toAccount.setBalance(toBalance);
                transaction.setTransactionDate(currentDate);
                transaction.setTransferAmountMoney(transactionDto.getTransferAmountMoney());
                transaction.setFromAccount(fromAccount.getAccountNumber());
                transaction.setToAccount(toAccount.getAccountNumber());
                transactionRepository.save(transaction);
            }catch (Exception e){
                throw new Exception("balance reicht nicht");
            }
        transactionRepository.save(transaction);
        return transaction.getId();
    }



    @Override
    public Long withdrawMoney(TransactionDto transactionDto) throws Exception {
        return null;
    }



    @Override
    public Long depositMoney(TransactionDto transactionDto) throws Exception {
           Account account = accountRepository.findAccountByAccountNumber(transactionDto.getToAccount()); // kolle objekt ro peyda mikone
           if(account == null) {
               throw  new Exception("Account Number hat nicht gefunden!!!");
           }
           if(transactionDto.getDepositAmountMoney() == null){
               throw new Exception("Euro muss eingetragen werden");
           }
           if(transactionDto.getDepositAmountMoney() < 5){
               throw new Exception("Betrag ist nicht gültig");
           }
           Transaction transaction = new Transaction();
           Date date = new Date();
           try{
               Integer accountBalance = account.getBalance(); // mojodi ro miporse line 76
               accountBalance += transactionDto.getDepositAmountMoney();
               transaction.setDepositAmountMoney(transactionDto.getDepositAmountMoney());
               transaction.setTransactionDate(date);
               transaction.setToAccount(account.getAccountNumber());
               account.setBalance(accountBalance);
               accountRepository.save(account);
               transactionRepository.save(transaction);
           }
           catch (Exception e){
               throw new Exception("Konto ist nicht gültig");
           }
           return transaction.getId();

    }
}
