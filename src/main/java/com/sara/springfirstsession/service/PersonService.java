package com.sara.springfirstsession.service;

import com.sara.springfirstsession.dto.PersonDto;
import com.sara.springfirstsession.model.Person;

import java.util.List;

public interface PersonService {
    Person getPerson(Person person);
    Person updatePerson(Person person) throws Exception;

    Person getOnePerson(Long personId) throws Exception;

    List<Person> findAll() throws  Exception;

    void delete(Long id) throws  Exception;

    Person searchByName(String name) throws  Exception;

    Person savePersonDto(PersonDto personDto) throws Exception;

    Person searchByEmail(String email) throws Exception;

    Person findByLastName(String lastName) throws  Exception;
}
