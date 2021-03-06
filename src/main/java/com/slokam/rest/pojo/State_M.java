package com.slokam.rest.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="state")
public class State_M {
  /*
   * <state id=1>
   *    
   *    <name> asdf</name>
   *    </state>
   */
	
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  
  @OneToMany(mappedBy="state")
  private List<City_M> cities;
  @ManyToOne
  @JoinColumn(name="cnid")
  @JsonIgnoreProperties("states")
  private Country_M country;
  
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
public List<City_M> getCities() {
	return cities;
}
public void setCities(List<City_M> cities) {
	this.cities = cities;
}
public Country_M getCountry() {
	return country;
}
public void setCountry(Country_M country) {
	this.country = country;
}
  
  
  
  
  
}
