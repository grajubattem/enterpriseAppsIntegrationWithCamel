package com.aprio.auditlogservice.model;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aprio.auditlogservice.service.Tutorialservice;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageProcessor implements Processor{

	Logger logger = LoggerFactory.getLogger(MessageProcessor.class);
	
	@Autowired
	Tutorialservice tutorialService;

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("MessageProcessor {}", exchange.getMessage().getBody());
		String queueResp = (String) exchange.getMessage().getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		Tutorial tutorial = objectMapper.readValue(queueResp, Tutorial.class);
		
		//tutorialService.saveTutorial(tutorial);
		System.out.println("saved object to db sucessfully");
	}
}
