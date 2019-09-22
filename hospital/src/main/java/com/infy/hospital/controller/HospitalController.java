package com.infy.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.hospital.service.PatientEntry;

@RestController
@CrossOrigin
public class HospitalController {

	@Autowired
	PatientEntry patientEntry;
	
	@RequestMapping(value = "/send/{id}", method = RequestMethod.GET)
	public String sendPatientDetails(@PathVariable Integer id) {
		try{return patientEntry.sendData(id);}
		catch(Exception e) {
			System.err.println("Error occured"+ e.getMessage());
		}
		
		return "error";
		
	}
}
