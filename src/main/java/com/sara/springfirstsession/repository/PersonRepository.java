package com.sara.springfirstsession.repository;

import com.sara.springfirstsession.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long >, JpaSpecificationExecutor<Person> {

    @Query("SELECT p FROM Person p where p.firstName =:firstName")
    Person findPersonByFirstName(@Param("firstName") String firstName);

    @Query("SELECT p FROM Person p where p.emailAddress =:email")
    Person searchByEmail(@Param("email") String email);










    Optional<Person> findById(Long id);
}
