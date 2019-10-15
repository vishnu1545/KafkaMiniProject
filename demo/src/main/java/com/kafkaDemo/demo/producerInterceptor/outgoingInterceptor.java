package com.kafkaDemo.demo.producerInterceptor;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.ClusterResource;
import org.apache.kafka.common.ClusterResourceListener;

public class outgoingInterceptor implements ProducerInterceptor<String, String> ,ClusterResourceListener{

	@Override
	public void configure(Map<String, ?> configs) {
		// configuration required if any
		
	}

	@Override
	public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
		//validation for kafka if required
		/*
		 * 
		 * record.headers().add(key, value);
		 * ProducerRecord<String, byte[]> record = new ProducerRecord<>(topic, key,
		 * message); Headers headers = record.headers();
		 * headers.add(KafkaHeaders.HEADER_CLIENT_IP,
		 * Strings.bytes(Network.localHostAddress()));
		 */
		System.err.println("Call--2");
		return record;
	}

	@Override
	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
		
		System.err.println("Call--3");
		//logging
	}

	@Override
	public void close() {
		
		System.err.println("Call--4");
	}

	@Override
	public void onUpdate(ClusterResource clusterResource) {
		//can make global instance of ClusterResource for looging if required
		System.err.println("Call--5");
		System.err.println(clusterResource);
	}

}
