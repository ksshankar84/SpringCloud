package com.shan.cloud.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
    	System.out.println("Message Sent - " + message);
        this.kafkaTemplate.send("test-topic", message);
    }
}
