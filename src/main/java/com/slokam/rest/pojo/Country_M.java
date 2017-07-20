package com.slokam.rest.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="country")
public class Country_M {
  
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  @OneToMany(mappedBy="country")
  @JsonIgnoreProperties("country")
  private List<State_M> states;

  public Integer getId() {
	return id;
  }
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<State_M> getStates() {
	return states;
}
public void setStates(List<State_M> states) {
	this.states = states;
}
  
  
}
