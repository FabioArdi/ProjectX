package com.data_management.projectx.restcontrollers;

import com.data_management.projectx.entities.Person;
import com.data_management.projectx.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonRestController {

    @Autowired
    PersonRepo repository;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> result = repository.findAll();
        if(!result.isEmpty()) {
            System.out.println(result.size());
            return new ResponseEntity<List<Person>>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
        Optional<Person> result = repository.findById(id);
        if(result.isEmpty()){
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Person>(result.get(), HttpStatus.OK);
    }
}
