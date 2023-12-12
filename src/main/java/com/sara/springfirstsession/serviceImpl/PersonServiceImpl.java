package com.sara.springfirstsession.serviceImpl;

import com.sara.springfirstsession.dto.PersonDto;
import com.sara.springfirstsession.repository.PersonRepository;
import com.sara.springfirstsession.model.Person;
import com.sara.springfirstsession.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonServiceImpl implements PersonService {




@Autowired
private PersonRepository personRepository;



    @Override
    public Person getPerson(Person person) {
    if(person.getFirstName() == null){
        System.out.println("name ist empty");
    }
    if(person.getLastName() == null){
        System.out.println("last name ist empty");
    }
    personRepository.save(person);
    return person;
    }




    @Override
    public Person updatePerson(Person person) throws Exception {
    Person personId = personRepository.findById(person.getId()).orElseThrow(()-> new Exception("Id not Found"));
    if(person.getFirstName() != null)
        personId.setFirstName(person.getFirstName());
    if(person.getLastName() != null)
        personId.setLastName((person.getLastName()));
    if(person.getMobile() != null)
        personId.setMobile(person.getMobile());
    if(person.getEmailAddress() != null)
        personId.setEmailAddress(person.getEmailAddress());

    personRepository.save(personId);
    return personId;

    }

    @Override
    public Person getOnePerson(Long personId) throws Exception {

        return personRepository.findById(personId).orElseThrow(()-> new Exception("Id not Found"));
    }

    @Override
    public List<Person> findAll() throws Exception {
        return personRepository.findAll();
    }

    @Override
    public void delete(Long id) throws Exception {
         personRepository.deleteById(id);
    }

    @Override
    public Person searchByName(String name) throws Exception {
        return personRepository.findPersonByFirstName(name);
    }

    @Override
    public Person savePersonDto(PersonDto personDto) throws Exception {
        Person person = new Person().fromDto(personDto);
        if(personDto.getFirstName() == null){
            throw new Exception("firstName ist null");
        }
        if(personDto.getLastName() == null){
            throw new Exception("lastName ist null");
        }
        if(personDto.getMobile() == null){
            throw new Exception("moblie ist null");
        }
        if(personDto.getEmailAddress() == null){
            throw new Exception("email ist null");
        }
        personRepository.save(person);
        return person;
    }

    @Override
    public Person searchByEmail(String email) throws Exception {
        return personRepository.searchByEmail(email);
    }

    @Override
    public Person findByLastName(String lastName) throws Exception {
        return personRepository.findByLastName(lastName);
    }
}
