package com.shan.cloud.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shan.cloud.client.service.ClientRestService;

@RestController
@EnableDiscoveryClient
public class ClientRestController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private ClientRestService clientService;
	
	@RequestMapping(value = "/echo/{msg}", method = RequestMethod.GET)
	public String echoMessage(@PathVariable String msg) {
		logger.info("Enter echoMessage");
		return "Client 2 echoing " + msg;
	}

	@RequestMapping(value = "/zookeeper-services", method = RequestMethod.GET)
	public List<String> printZookeeperServices() {
		logger.info("Enter printZookeeperServices");
		List<String> list = discoveryClient.getServices();
		logger.info("Enter printZookeeperServices");
		return list;
	}
	
	@RequestMapping(value = "/zookeeper-instances/{serviceName}", method = RequestMethod.GET)
	public List<ServiceInstance> printZookeeperInstances(@PathVariable String serviceName) {
		logger.info("Enter printZookeeperInstances");
		List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
		logger.info("Enter printZookeeperInstances");
		return list;
	}
	
	@RequestMapping(value = "/zookeeper-instances/cloudSvcCall/{serviceName}", method = RequestMethod.GET)
	public void invokeCloudService(@PathVariable String serviceName) {
		logger.info("Enter invokeCloudService");
		String uri = discoveryClient.getInstances(serviceName).get(0).getUri().toString() + "/" + serviceName;
		this.clientService.invokeCloudService(uri);
		logger.info("Enter invokeCloudService");
	}
}
