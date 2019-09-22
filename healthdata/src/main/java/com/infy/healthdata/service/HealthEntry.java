package com.infy.healthdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.healthdata.dto.EmployeeDTO;
import com.infy.healthdata.dto.PatientDTO;

@Service
@KafkaListener(topics = "patient101", groupId = "group_json",containerFactory = "userKafkaListenerFactory")
public class HealthEntry {
	
	 @Autowired
	 private RestTemplate restTemplate;

	
	@KafkaHandler
	public void consume(PatientDTO patient) {
		EmployeeDTO employee=restTemplate.getForObject("http://localhost:8100/employee/"+patient.getEmpId(), EmployeeDTO.class);
		
		System.out.println(employee);
		System.out.println(patient);
	}

}

