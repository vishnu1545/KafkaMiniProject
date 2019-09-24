package com.infy.hospital.service;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.hospital.dto.PatientDTO;
import com.infy.hospital.validator.Validation;

@Service
public class PatientEntry {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private KafkaTemplate<String, PatientDTO> kafkaTemplate;

	public static final String TOPIC = "patient101";

	public String sendData(Integer id) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		PatientDTO patientFromFile = objectMapper.readValue(new File("patient" + id + ".json"), PatientDTO.class);
		Validation validator = new Validation();
		try {
			validator.validate(patientFromFile);
			kafkaTemplate.send(TOPIC, patientFromFile);
			return "Success";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "failure because: " + e.getMessage();

		}
	}
}
