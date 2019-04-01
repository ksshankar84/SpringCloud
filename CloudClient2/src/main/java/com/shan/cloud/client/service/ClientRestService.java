package com.shan.cloud.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientRestService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private RestTemplate restTemplate = new RestTemplate();
	
	public void invokeCloudService(String url) {
		logger.info("Enter invokeCloudService");
		String response = this.restTemplate.getForObject(url + "/echo/Invoked by client 2", String.class);
		System.err.println(response);
		logger.info("Exit invokeCloudService");
	}
}
