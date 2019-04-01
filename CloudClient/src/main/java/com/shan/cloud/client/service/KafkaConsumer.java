package com.shan.cloud.client.service;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	//@KafkaListener(topics = "test-topic", groupId = "group_id")
	public void consume(String message) throws IOException {
		System.out.println("Message Received - " + message);
	}
}
