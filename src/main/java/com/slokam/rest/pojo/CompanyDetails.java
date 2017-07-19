package com.slokam.rest.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CompanyDetails")
public class CompanyDetails {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToMany(mappedBy="company")
	private List<Recruiter> recruiters;
	
	public List<Recruiter> getRecruiters() {
		return recruiters;
	}
	public void setRecruiters(List<Recruiter> recruiters) {
		this.recruiters = recruiters;
	}
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

	
}
