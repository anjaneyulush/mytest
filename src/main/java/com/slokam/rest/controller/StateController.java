package com.slokam.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.rest.pojo.State_M;
import com.slokam.rest.service.StateService;

@RestController
@RequestMapping("state")
public class StateController {
    private static final  Logger LOGGER = Logger.getLogger(StateController.class);  
	@Autowired
	private StateService stateService;
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> saveState(@RequestBody State_M state) {
	
		stateService.saveState(state);
		return new ResponseEntity<String>("Successfully saved.",HttpStatus.CREATED); 
	     
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/byName/{name}")
	public ResponseEntity<List<State_M>> getStatesByName(@PathVariable String name ) { 
		List<State_M>  states = stateService.getStatesByName(name);
		ResponseEntity<List<State_M>> re = new ResponseEntity<List<State_M>>(states,HttpStatus.OK); 
	    return re;
	}
	
/*	@RequestMapping(method=RequestMethod.GET,value="/byNameQ/{name}/{id}")
	public ResponseEntity<Iterable<State_M>> getStatesByName2(@PathVariable String name,@PathVariable Integer id ) { 
		Iterable<State_M>  states = stateService.searchStatesByName(name,id);
		ResponseEntity<Iterable<State_M>> re = new ResponseEntity<Iterable<State_M>>(states,HttpStatus.OK); 
	    return re;
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity< List<State_M>> getStates() { 
		LOGGER.info("LOGGING TEST MESSAGE ...");
		List<State_M>  states = stateService.getStates();
		ResponseEntity< List<State_M>> re = new ResponseEntity<>(states,HttpStatus.OK); 
	    return re;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ResponseEntity<List<Object[]>> getStatesById(@PathVariable Integer id ) { 
		List<Object[]>  states = stateService.getStatesById(id);
		ResponseEntity<List<Object[]>> re = new ResponseEntity<List<Object[]>>(states,HttpStatus.OK); 
	    return re;
	}
		
	
	@RequestMapping(method=RequestMethod.GET,value="/getCountry/{stateName}")
	public ResponseEntity<String> getCountryNameByStateName(@PathVariable String stateName){
		String country = stateService.getCountryNameByStateName(stateName);
		ResponseEntity<String> re = new ResponseEntity<String>(country,HttpStatus.OK);
		return re;
	}
	
}
