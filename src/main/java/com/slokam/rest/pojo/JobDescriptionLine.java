package com.slokam.rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="JobDescriptionLine")
public class JobDescriptionLine {

	@Id
	@GeneratedValue
	private Integer id;
	private String descrition;
	@ManyToOne
	@JoinColumn(name="jdid")
	private JobDescription jd;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public JobDescription getJd() {
		return jd;
	}
	public void setJd(JobDescription jd) {
		this.jd = jd;
	}
	
	
	
}
