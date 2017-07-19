package com.slokam.rest.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="JobDescription")
public class JobDescription  {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name="rlid")
	private Role_M role;
	@ManyToOne
	@JoinColumn(name="emptyId")
	private EmploymentType_M employmentType;
	@ManyToOne
	@JoinColumn(name="recid")
	private Recruiter recruiter;
	private String refId;
	private Integer positions;
	@ManyToMany
	@JoinTable(name="jd_skill",
	joinColumns={@JoinColumn(name="jdid")},
	inverseJoinColumns={@JoinColumn(name="skid")})
	private List<Skill_M>  skills;
	@OneToMany(mappedBy="jd")
	private List<JobDescriptionLine> descriptionLines;
	@OneToOne(mappedBy="jd")
	private SalaryDetails salaryDetails;
	
	
	public SalaryDetails getSalaryDetails() {
		return salaryDetails;
	}
	public void setSalaryDetails(SalaryDetails salaryDetails) {
		this.salaryDetails = salaryDetails;
	}
	public List<JobDescriptionLine> getDescriptionLines() {
		return descriptionLines;
	}
	public void setDescriptionLines(List<JobDescriptionLine> descriptionLines) {
		this.descriptionLines = descriptionLines;
	}
	public List<Skill_M> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill_M> skills) {
		this.skills = skills;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Role_M getRole() {
		return role;
	}
	public void setRole(Role_M role) {
		this.role = role;
	}
	public EmploymentType_M getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(EmploymentType_M employmentType) {
		this.employmentType = employmentType;
	}
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public Integer getPositions() {
		return positions;
	}
	public void setPositions(Integer positions) {
		this.positions = positions;
	}
	
	
	
	
	
}
