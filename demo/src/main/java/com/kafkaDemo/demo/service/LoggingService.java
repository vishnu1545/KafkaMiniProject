package com.kafkaDemo.demo.service;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kafkaDemo.demo.model.Patient;

@Service
public class LoggingService {
	private static final Logger logger = LogManager.getLogger(LoggingService.class);
	public Patient dataFeeder(Patient p) {
		p.setBloodG("B+");
		p.setCreditCard(123456789123L);
		p.setDob(LocalDate.of(1996,11,14));
		p.setEmail("vu@gmail.com");
		p.setName("Vinu");
		p.setPhoneNo(9884213512L);
		p.setSugarLv(180.0);
		logger.error(p);
		return p;
	}
	public String dataGetter(Patient p) {
		System.out.println(p);
		logger.error(p);
		return "Success";
	}
	public void loggingService() {
		
	}
}
