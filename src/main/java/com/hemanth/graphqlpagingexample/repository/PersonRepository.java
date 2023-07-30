package com.hemanth.graphqlpagingexample.repository;

import com.hemanth.graphqlpagingexample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {


}
