package com.kafkaDemo.demo.model;

import java.time.LocalDate;

public class Patient {

	private String name;
	private Long creditCard;
	private Long phoneNo;
	private LocalDate dob;
	private String email;
	
	private Double sugarLv;
	private String bloodG;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSugarLv() {
		return sugarLv;
	}
	public void setSugarLv(Double sugarLv) {
		this.sugarLv = sugarLv;
	}
	public String getBloodG() {
		return bloodG;
	}
	public void setBloodG(String bloodG) {
		this.bloodG = bloodG;
	}
	@Override
	public String toString() {
		return "Patient [name=" + name + ", creditCard=" + creditCard + ", phoneNo=" + phoneNo + ", dob=" + dob
				+ ", email=" + email + ", sugarLv=" + sugarLv + ", bloodG=" + bloodG + "]";
	}
	
	
	
}
