package com.centime.hello.controller;

import com.centime.hello.model.Person;
import com.centime.hello.service.PersonService;
import com.centime.hello.util.LogMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    @LogMethodParam
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        return ResponseEntity.of(personService.getPerson(id));
    }

    @GetMapping
    @LogMethodParam
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok().body(personService.getPersons());
    }


}
