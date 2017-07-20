package com.slokam.rest.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.slokam.rest.pojo.Country_M;
import com.slokam.rest.pojo.State_M;

public class StateControllerTest2 {

	@Test
	public void test1() throws Exception{
	   	
		Country_M country = new Country_M();
		country.setId(1);
		State_M state = new State_M();
		state.setName("Test");
		state.setCountry(country);
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject("http://localhost:8080/state",state,String.class);
		Assert.assertEquals("Successfully saved.", response);
		
	}
	 

}
