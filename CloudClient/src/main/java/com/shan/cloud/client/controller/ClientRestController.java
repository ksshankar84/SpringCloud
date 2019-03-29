package com.shan.cloud.client.controller;

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
	
	@Autowired
	KafkaProducer kafkaProducer;

	@RequestMapping(value = "/echo/{msg}", method = RequestMethod.POST)
	public String custom(@PathVariable String msg) {
		return msg;
	}
	
	@RequestMapping(value = "/kafka/publish/{msg}", method = RequestMethod.POST)
	public void publishMessage(@PathVariable String msg) {
		this.kafkaProducer.sendMessage(msg);
	}
}
