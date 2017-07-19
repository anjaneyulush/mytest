package com.slokam.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.rest.dao.CountryDAO;
import com.slokam.rest.pojo.Country_M;

@Service
public class CountryService {
	@Autowired
	private CountryDAO countryDao;
	
  public void saveCountry(Country_M country){
	  countryDao.save(country);
  }
}
