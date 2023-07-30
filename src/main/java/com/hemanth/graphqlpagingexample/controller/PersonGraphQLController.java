package com.hemanth.graphqlpagingexample.controller;

import com.hemanth.graphqlpagingexample.model.Person;
import com.hemanth.graphqlpagingexample.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonGraphQLController {

    private final PersonRepository personRepository;

    public PersonGraphQLController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @QueryMapping
    public Iterable<Person> allPeople() {
        return personRepository.findAll();
    }

    @QueryMapping
    public Page<Person> allPeoplePaged(@Argument int page, @Argument int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return personRepository.findAll(pageRequest);
    }
}
