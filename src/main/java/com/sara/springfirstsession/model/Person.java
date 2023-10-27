package com.sara.springfirstsession.model;

import com.sara.springfirstsession.dto.PersonDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "person")
@Accessors(chain = true)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "emailAddress")
    private String emailAddress;


    public Person fromDto(PersonDto personDto){

        Person person = new Person();
        person.setId(personDto.getId());
        person.setMobile(personDto.getMobile());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmailAddress(personDto.getEmailAddress());

        return person;
    }

}
