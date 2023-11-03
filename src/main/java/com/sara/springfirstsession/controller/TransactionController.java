package com.sara.springfirstsession.controller;


import com.sara.springfirstsession.dto.TransactionDto;
import com.sara.springfirstsession.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // har noe data ro ghabol kon(unlimited) Foto...
@RequestMapping("TransactionController")
@Controller   //HTTP methode
public class TransactionController {


    @Autowired
    private TransactionService transactionService;

    @PostMapping(value = "transferMoney") //create a Record in Database ; URL:Keine Gesetze für Namen
    public ResponseEntity transferMoney(@RequestBody TransactionDto transactionDto) throws Exception{


        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.transactionService.transferMoney(transactionDto));
        } catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
