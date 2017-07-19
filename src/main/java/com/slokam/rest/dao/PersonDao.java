package com.slokam.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slokam.rest.pojo.Person;

public interface PersonDao  extends JpaRepository<Person, Integer>{

}
