package com.kafkaDemo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafkaDemo.demo.model.Patient;
@Service
public class ProducerService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	public void producePatient(Patient p)
	{

		//ProducerRecord<String,Patient> record =new ProducerRecord<>("patient", new Patient());
		Message<Patient> mg=MessageBuilder.withPayload(p)
				.setHeader(KafkaHeaders.TOPIC, "patient")
				.setHeader("headerName", "headerValue")
				.build();
		try {
			
			ListenableFuture<SendResult<String, String>> future=kafkaTemplate.send(mg);
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>(){
					@Override
					public void onSuccess(SendResult<String, String> result) {
						
						System.err.println("Call--1");
						//topic-partition@offset
					    System.err.println(result.getRecordMetadata());			
					}
					@Override
					public void onFailure(Throwable ex) {
					//throw ex;
					}
					});
			
		}
		catch(Exception e) {
			System.err.println("Error has occured+    "+e.getMessage());
		}
	}
}
