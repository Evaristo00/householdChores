package com.personservice.controller;

import com.personservice.dto.PersonDto;
import com.personservice.entity.Person;
import com.personservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        List<Person> persons = personService.getAll();
        if(persons.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id){
        Person person = personService.getPersonById(id);
        if(person == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(person)  ;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> upload(@PathVariable("id") int id,@RequestBody PersonDto personDto) throws Exception {
        return ResponseEntity.ok(personService.update(id,personDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(personService.delete(id));
    }


    /*
    *************
    HOME CONTROLLERS
    *************
    */

    @GetMapping("house/{id}")
    public ResponseEntity<List<Person>> getHouseById(@PathVariable int id){
        List<Person> persons = personService.getPersoninHome(id);
        if(persons.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(persons);
    }
}
