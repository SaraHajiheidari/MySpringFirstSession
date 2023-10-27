package com.sara.springfirstsession.controller;

import com.sara.springfirstsession.dto.PersonDto;
import com.sara.springfirstsession.model.Person;
import com.sara.springfirstsession.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("PersonController")
@Controller
public class PersonController {


    @Autowired
    private PersonService personService;




    @PostMapping(value = "SavePerson")
    public ResponseEntity<Object> createPerson(@RequestBody Person person){

        return new ResponseEntity<>(personService.getPerson(person), HttpStatus.CREATED);

    }

    @PutMapping(value = "UpdatePerson")
    public ResponseEntity<Object> update(@RequestBody Person person) throws Exception {
        return new ResponseEntity<>(personService.updatePerson(person), HttpStatus.CREATED);
    }

    @RequestMapping(value ="findOnePersonInternational/{id}")
    public ResponseEntity<Person> findOnePerson(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(personService.getOnePerson(id),HttpStatus.OK);
    }

    @RequestMapping(value = "findAllInternational" )
    public ResponseEntity<Person> findAll() throws  Exception{
        return new ResponseEntity(personService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteInternational/{id}" )
    public void deleteById(@PathVariable Long id) throws  Exception{
        personService.delete(id);
    }

    @GetMapping (value ="searchByName/{firstName}")
    public Person searchByName(@PathVariable String firstName) throws Exception {
        return personService.searchByName(firstName);
    }

    @PostMapping(value = "saveByDtoInternational")
    public ResponseEntity<Person> saveByDto(@RequestBody PersonDto personDto) throws Exception{
        return new ResponseEntity(personService.savePersonDto(personDto),HttpStatus.CREATED);
        }

        @GetMapping (value = "searchByEmail/{email}")
    public Person searchByEmail(@PathVariable String email) throws Exception{
        return personService.searchByEmail(email);
        }
}

