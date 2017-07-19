package com.slokam.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.rest.pojo.Country_M;
import com.slokam.rest.service.CountryService;

@RestController
@RequestMapping("country")
public class CountryController {
	@Autowired
    private CountryService countryService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> saveCountry(@RequestBody Country_M country){
		ResponseEntity en = new ResponseEntity("Successfully saved.",HttpStatus.CREATED);
		countryService.saveCountry(country);
		return en;
	}
}
