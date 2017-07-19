package com.slokam.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.rest.pojo.Country_M;

@Repository
public interface CountryDAO extends JpaRepository<Country_M, Integer>{

	 
}
