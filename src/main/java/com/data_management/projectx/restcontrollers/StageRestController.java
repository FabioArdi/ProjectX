package com.data_management.projectx.restcontrollers;

import com.data_management.projectx.entities.Stage;
import com.data_management.projectx.repos.StageRepo;
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
public class StageRestController {

    @Autowired
    StageRepo repository;

    @RequestMapping(value = "/stages", method = RequestMethod.GET)
    public ResponseEntity<List<Stage>> getStages() {
        List<Stage> result = repository.findAll();
        if(!result.isEmpty()) {
            return new ResponseEntity<List<Stage>>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/stages/{id}", method = RequestMethod.GET)
    public ResponseEntity<Stage> getStage(@PathVariable("id") long id) {
        Optional<Stage> result = repository.findById(id);
        if(result.isEmpty()){
            return new ResponseEntity<Stage>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Stage>(result.get(), HttpStatus.OK);
    }
}
