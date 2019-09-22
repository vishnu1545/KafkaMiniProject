package com.infy.hospital.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.hospital.dto.PatientDTO;

@Service
public class PatientEntry {
	@Autowired
	private KafkaTemplate<String,PatientDTO> kafkaTemplate;
	
	public static final String TOPIC="patient101";
	
	public String sendData(Integer id) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
        PatientDTO patient = objectMapper.readValue(new File("patient"+id+".json"), PatientDTO.class);
		kafkaTemplate.send(TOPIC, patient);
		return "Success";
	}
}

