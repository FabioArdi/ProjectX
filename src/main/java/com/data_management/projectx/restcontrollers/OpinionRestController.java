package com.data_management.projectx.restcontrollers;

import com.data_management.projectx.entities.Opinion;
import com.data_management.projectx.repos.OpinionRepo;
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
public class OpinionRestController {

    @Autowired
    OpinionRepo repository;

    @RequestMapping(value = "/opinions", method = RequestMethod.GET)
    public ResponseEntity<List<Opinion>> getOpionions() {
        List<Opinion> result = repository.findAll();
        if(!result.isEmpty()) {
            return new ResponseEntity<List<Opinion>>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/opinions/{id}", method = RequestMethod.GET)
    public ResponseEntity<Opinion> getOpionions(@PathVariable("id") long id) {
        Optional<Opinion> result = repository.findById(id);
        if(result.isEmpty()){
            return new ResponseEntity<Opinion>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Opinion>(result.get(), HttpStatus.OK);
    }
}
