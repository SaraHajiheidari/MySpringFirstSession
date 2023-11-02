package com.sara.springfirstsession.dto;
import com.sara.springfirstsession.enums.AccountTypes;
import com.sara.springfirstsession.model.Account;
import com.sara.springfirstsession.model.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class AccountDto {

    private Long id;
    private  Integer accountNumber;
    private Integer balance;
    private Double interestRate;
    private Double interest;
    private AccountTypes accountTypes;
    private LocalDateTime createdAt;
    private Person personId;

    public AccountDto toAccount(Account account){

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setInterestRate(account.getInterestRate());
        accountDto.setInterest(account.getInterest());
        accountDto.setAccountTypes(account.getAccountTypes());
        accountDto.setCreatedAt(account.getCreatedAt());
        accountDto.setPersonId(account.getPersonId());
        return accountDto;
    }


}
