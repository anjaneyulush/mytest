package com.slokam.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.rest.dao.PersonDao;
import com.slokam.rest.pojo.Person;

@RestController
@RequestMapping("person")
public class TestRest  {

	@Autowired
	private PersonDao personDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Person> getData(Integer id){
		Person person = personDao.findOne(id);
		ResponseEntity re =  null; 
		if(person == null ){
			re =new ResponseEntity<Person>(person,HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<Person>(person,HttpStatus.OK);
		}
		return re;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Person> getAll(){
		List<Person> persons = personDao.findAll();
		return persons;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity saveData(@RequestBody Person person){
		
		if(person.getName() ==null || person.getName().trim().length()==0)
		{
			return new ResponseEntity("Name is required.",HttpStatus.BAD_REQUEST);
		}
		personDao.save(person);
		ResponseEntity re = new ResponseEntity(HttpStatus.CREATED);
		return re;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity deleteData(@RequestBody Person person){
		personDao.delete(person);
		ResponseEntity re = new ResponseEntity(HttpStatus.NO_CONTENT);
		return re;
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity updateData(@RequestBody Person person){
		personDao.save(person);
		ResponseEntity re = new ResponseEntity(HttpStatus.NO_CONTENT);
		return re;
	}
	
}
