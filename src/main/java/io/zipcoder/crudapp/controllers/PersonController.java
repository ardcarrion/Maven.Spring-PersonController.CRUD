package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.entities.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository repository;

    @RequestMapping(value="/people", method=RequestMethod.POST)
    Person createPerson(@RequestBody Person p) {
        return repository.save(p);
    }
    @RequestMapping(value="/people/{id}", method=RequestMethod.GET)
    Person getPerson(@PathVariable int id) {
        return repository.findOne(id);
    }
    @RequestMapping(value="/people", method=RequestMethod.GET)
    Iterable<Person> getPersonList() {
        return repository.findAll();
    }
    @RequestMapping(value="/people/{id}", method =RequestMethod.PUT)
    Person updatePerson(@RequestBody Person p, @PathVariable int id){
        return repository.save(p);
    }
    @RequestMapping(value="/person/{id}")
    void deletePerson(@PathVariable int id){
        repository.delete(id);
    }

}
