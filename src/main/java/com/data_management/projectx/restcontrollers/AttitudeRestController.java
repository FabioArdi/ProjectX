package com.data_management.projectx.restcontrollers;

import com.data_management.projectx.entities.Attitude;
import com.data_management.projectx.repos.AttitudeRepo;
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
public class AttitudeRestController {

    @Autowired
    AttitudeRepo repository;

    @RequestMapping(value = "/attitudes", method = RequestMethod.GET)
    public ResponseEntity<List<Attitude>> getAttitudes() {
        List<Attitude> result = repository.findAll();
        if(!result.isEmpty()) {
            return new ResponseEntity<List<Attitude>>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/attitudes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Attitude> getAttitudes(@PathVariable("id") long id) {
        Optional<Attitude> result = repository.findById(id);
        if(result.isEmpty()){
            return new ResponseEntity<Attitude>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Attitude>(result.get(), HttpStatus.OK);
    }
}
