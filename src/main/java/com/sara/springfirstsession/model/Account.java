package com.sara.springfirstsession.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sara.springfirstsession.dto.AccountDto;
import com.sara.springfirstsession.enums.AccountTypes;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "account")
@Accessors(chain = true)
public class Account {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @Column(name = "account-number")
    private  Integer accountNumber;


    @Column(name = "balance")
    private Integer balance;

    @Column(name = "interest-rate")
    private Double interestRate;

    @Column(name = "interest")
    private Double interest;


    @Enumerated(EnumType.STRING)
    @Column(name = "account-types")
    private AccountTypes accountTypes;


    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-mm-dd hh:mm:ss" )
    @Column(name = "created-at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER , targetEntity = Person.class)
    @JoinColumn(name = "person_Id" , foreignKey = @ForeignKey(name = "fk_person_Id"))
    private Person personId;

    public Account fromAccountDto(AccountDto accountDto){

        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setInterestRate(accountDto.getInterestRate());
        account.setInterest(accountDto.getInterest());
        account.setAccountTypes(accountDto.getAccountTypes());
        account.setCreatedAt(accountDto.getCreatedAt());
        account.setPersonId(accountDto.getPersonId());
        return account;

    }
}
