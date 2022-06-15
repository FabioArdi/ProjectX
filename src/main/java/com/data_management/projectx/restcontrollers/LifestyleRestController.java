package com.data_management.projectx.restcontrollers;

import com.data_management.projectx.entities.Lifestyle;
import com.data_management.projectx.repos.LifestyleRepo;
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
public class LifestyleRestController {

    @Autowired
    LifestyleRepo repository;

    @RequestMapping(value = "/lifestyles", method = RequestMethod.GET)
    public ResponseEntity<List<Lifestyle>> getLifestyles() {
        List<Lifestyle> result = repository.findAll();
        if(!result.isEmpty()) {
            return new ResponseEntity<List<Lifestyle>>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/lifestyles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Lifestyle> getLifestyles(@PathVariable("id") long id) {
        Optional<Lifestyle> result = repository.findById(id);
        if(result.isEmpty()){
            return new ResponseEntity<Lifestyle>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Lifestyle>(result.get(), HttpStatus.OK);
    }
}
