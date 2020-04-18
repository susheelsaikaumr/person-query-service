package com.centime.hello.service;

import com.centime.hello.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getPerson(Integer id);

    List<Person> getPersons();
}
