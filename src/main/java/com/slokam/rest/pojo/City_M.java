package com.slokam.rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City_M {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name="stid")
	private State_M state;
	
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
	public State_M getState() {
		return state;
	}
	public void setState(State_M state) {
		this.state = state;
	}
	
	
}
