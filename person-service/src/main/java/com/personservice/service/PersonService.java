package com.personservice.service;

import com.personservice.dto.PersonDto;
import com.personservice.entity.Person;
import com.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).orElse(null);
    }

    public Person save(PersonDto personDto){
        Person person = new Person(null, personDto.getName(),personDto.getMail(),personDto.getPassword());
        return personRepository.save(person);
    }

    public Person update(int id, PersonDto personDto) throws Exception {
        if(personRepository.findById(id).isEmpty())
            throw  new Exception();
        Person person = personRepository.findById(id).get();
        person.setName(personDto.getName());
        person.setMail(personDto.getMail());
        person.setPassword(personDto.getPassword());

        return personRepository.save(person);
    }

    public Person delete(int id) throws Exception {
        if(personRepository.findById(id).isEmpty())
            throw  new Exception();
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
        return person;
    }
}
