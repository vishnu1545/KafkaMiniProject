package com.infy.healthdata.dto;

import java.util.List;

public class PatientDTO {
 private Integer id;
 private String name;
 private String email;
 private Long phone;
 private Integer empId;
 private String company;
 private List<String> issues;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public List<String> getIssues() {
	return issues;
}
public void setIssues(List<String> issues) {
	this.issues = issues;
}
@Override
public String toString() {
	return "Patient {id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", empId=" + empId
			+ ", company=" + company + ", issues=" + issues + "}";
}
 
 
}
