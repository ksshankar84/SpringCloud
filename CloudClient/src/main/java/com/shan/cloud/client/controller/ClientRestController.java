package com.shan.cloud.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shan.cloud.client.service.KafkaProducer;

@RestController
@EnableDiscoveryClient
public class ClientRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	KafkaProducer kafkaProducer;

	@RequestMapping(value = "/echo/{msg}", method = RequestMethod.GET)
	public String echoMessage(@PathVariable String msg) {
		logger.info("Enter echoMessage");
		return "Client 1 echoing " + msg;
	}
	
	@RequestMapping(value = "/kafka/publish/{msg}", method = RequestMethod.GET)
	public void publishMessage(@PathVariable String msg) {
		logger.info("Enter publishMessage");
		this.kafkaProducer.sendMessage(msg);
		logger.info("Exit publishMessage");
	}
}
