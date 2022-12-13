package nus.iss.myApi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nus.iss.myApi.Model.Person;
import nus.iss.myApi.service.PerconService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PerconService personService;

    @Autowired
    public PersonController(PerconService perconService){
        this.personService = perconService;
    }



    // @PostMapping
    // public void addPerson(@RequestBody Person person){
    //     personService.addPerson(person);
    // }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }


    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        Person personn = personService.addPerson(person);
        return new ResponseEntity<>(personn, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public Person getPersonId(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }


    @DeleteMapping(path="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
