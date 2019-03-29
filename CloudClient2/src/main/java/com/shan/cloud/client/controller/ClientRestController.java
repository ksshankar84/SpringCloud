package com.shan.cloud.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class ClientRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/echo/{msg}", method = RequestMethod.POST)
	public String custom(@PathVariable String msg) {
		return msg;
	}

	@RequestMapping(value = "/zookeeper-services", method = RequestMethod.GET)
	public void printZookeeperServices() {
		List<String> list = discoveryClient.getServices();
		for (String si : list) {
			System.out.println(si);
		}
	}
	
	@RequestMapping(value = "/zookeeper-instances", method = RequestMethod.GET)
	public void printZookeeperInstances() {
		List<ServiceInstance> list = discoveryClient.getInstances("CloudClient1");
		for (ServiceInstance si : list) {
			System.out.println(si.getInstanceId() + "-" + si.getUri());
		}
	}
}
