package com.centime.hello.service.impl;

import com.centime.hello.model.Person;
import com.centime.hello.repository.PersonRepository;
import com.centime.hello.service.PersonService;
import com.centime.hello.util.LogMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @LogMethodParam
    public Optional<Person> getPerson(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
       return personRepository.findById(id);
    }

    @Override
    @LogMethodParam
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
