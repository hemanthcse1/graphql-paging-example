package com.hemanth.graphqlpagingexample.controller;

import com.hemanth.graphqlpagingexample.model.Person;
import com.hemanth.graphqlpagingexample.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final PersonRepository personRepository;

    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Page<Person> findAllPeople(@RequestParam int page, @RequestParam int size, @RequestParam String sort){
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by(sort));
        return personRepository.findAll(pageRequest);
    }
}
