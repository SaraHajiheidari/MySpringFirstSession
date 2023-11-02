package com.sara.springfirstsession.dto;

import com.sara.springfirstsession.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonDto {    //Data Transfer Objekt


    private Long id;


    private String firstName;


    private String lastName;


    private String mobile;


    private String emailAddress;

    public PersonDto fromEntity(Person person){

        PersonDto personDto= new PersonDto();
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setMobile(person.getMobile());
        personDto.setEmailAddress(person.getEmailAddress());

        return  personDto;
    }


}
