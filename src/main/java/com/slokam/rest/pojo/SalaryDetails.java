package com.slokam.rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SalaryDetails")
public class SalaryDetails {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer FromSalaryLaks;
	private Integer FromSalaryThousands;
	private Integer UptoSalaryLaks;
	private Integer UptoSalaryThousands;
	@OneToOne
	@JoinColumn(name="jdid")
	private JobDescription jd;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFromSalaryLaks() {
		return FromSalaryLaks;
	}
	public void setFromSalaryLaks(Integer fromSalaryLaks) {
		FromSalaryLaks = fromSalaryLaks;
	}
	public Integer getFromSalaryThousands() {
		return FromSalaryThousands;
	}
	public void setFromSalaryThousands(Integer fromSalaryThousands) {
		FromSalaryThousands = fromSalaryThousands;
	}
	public Integer getUptoSalaryLaks() {
		return UptoSalaryLaks;
	}
	public void setUptoSalaryLaks(Integer uptoSalaryLaks) {
		UptoSalaryLaks = uptoSalaryLaks;
	}
	public Integer getUptoSalaryThousands() {
		return UptoSalaryThousands;
	}
	public void setUptoSalaryThousands(Integer uptoSalaryThousands) {
		UptoSalaryThousands = uptoSalaryThousands;
	}
	public JobDescription getJd() {
		return jd;
	}
	public void setJd(JobDescription jd) {
		this.jd = jd;
	}
	
	
	
}
