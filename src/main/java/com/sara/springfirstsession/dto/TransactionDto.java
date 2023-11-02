package com.sara.springfirstsession.dto;
import com.sara.springfirstsession.model.Account;
import com.sara.springfirstsession.model.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;





@Getter
@Setter
@Accessors(chain = true)
public class TransactionDto {

    private Long id;
    private Integer fromAccount;
    private Integer toAccount;
    private  Integer transferAmountMoney;
    private Integer depositAmountMoney;
    private Integer withdrawAmountMoney;
    private Date transactionDate;
    private List<AccountDto> accountList;


    public TransactionDto toTransaction(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setFromAccount(transaction.getFromAccount());
        transactionDto.setToAccount(transaction.getToAccount());
        transactionDto.setTransferAmountMoney(transaction.getTransferAmountMoney());
        transactionDto.setDepositAmountMoney(transaction.getDepositAmountMoney());
        transactionDto.setWithdrawAmountMoney(transaction.getWithdrawAmountMoney());
        transactionDto.setTransactionDate(transaction.getTransactionDate());
        return transactionDto;
    }
}
