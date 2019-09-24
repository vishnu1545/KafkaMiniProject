package com.infy.healthdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.healthdata.dto.EmployeeDTO;
import com.infy.healthdata.dto.PatientDTO;
import com.infy.healthdata.entity.HealthSheet;
import com.infy.healthdata.repo.HealthDataRepository;

@Service
@KafkaListener(topics = "patient101", groupId = "group_json",containerFactory = "userKafkaListenerFactory")
public class HealthEntry {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	 @Autowired
	 private RestTemplate restTemplate;

	 @Autowired
	 HealthDataRepository healthRepo;
	
	@KafkaHandler
	public void consume(PatientDTO patient) {
		EmployeeDTO employee=restTemplate.getForObject("http://localhost:8100/employee/"+patient.getEmpId(), EmployeeDTO.class);
		if(employee.getEmpId()==null || employee.getEmpId()==0)
			logger.error("Invalid Employee Id for patient :"+ patient.getId());
		else
		{
			HealthSheet healthsheetToRepo=populate(employee,patient);
			healthRepo.saveAndFlush(healthsheetToRepo);
			logger.info("Patient {} saved ",patient.getId());
			
		}
	}


	private HealthSheet populate(EmployeeDTO employee, PatientDTO patient) {
		HealthSheet healthSheet=new HealthSheet();
		healthSheet.setEmpId(employee.getEmpId());
		healthSheet.setCompany(patient.getCompany());
		healthSheet.setEmail(patient.getEmail());
		healthSheet.setInsurance(employee.getSalary()/10.0);
		healthSheet.setIssues(patient.getIssues().toString());
		healthSheet.setName(patient.getName());
		healthSheet.setPatientId(patient.getId());
		healthSheet.setPhone(patient.getPhone());
		return healthSheet;
	}

}

