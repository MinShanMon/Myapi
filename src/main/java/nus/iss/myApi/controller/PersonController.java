package nus.iss.myApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }




}
