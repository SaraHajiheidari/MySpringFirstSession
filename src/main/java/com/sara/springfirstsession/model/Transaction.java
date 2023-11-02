package com.sara.springfirstsession.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sara.springfirstsession.dto.TransactionDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "transaction")
@Accessors(chain = true)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "from_account")
    private Integer fromAccount;

    @Column(name ="to_account")
    private Integer toAccount;

    @Column(name = "transfer_amount_money")
    private  Integer transferAmountMoney;

    @Column(name = "deposit_amount_money")
    private Integer depositAmountMoney;

    @Column(name ="withdraw_amount_money")
    private Integer withdrawAmountMoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name ="transaction_date")
    private Date transactionDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Account> accountList;

    public Transaction fromTransactionDto(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        transaction.setFromAccount(transactionDto.getFromAccount());
        transaction.setToAccount(transactionDto.getToAccount());
        transaction.setTransferAmountMoney(transactionDto.getTransferAmountMoney());
        transaction.setDepositAmountMoney(transactionDto.getDepositAmountMoney());
        transaction.setWithdrawAmountMoney(transactionDto.getWithdrawAmountMoney());
        transaction.setTransactionDate(transactionDto.getTransactionDate());
        return transaction;
    }

}
