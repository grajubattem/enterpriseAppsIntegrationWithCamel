package com.aprio.auditlogservice.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Message {
	
	Logger logger = LoggerFactory.getLogger(MessageProcessor.class);
	
	public Tutorial getLogMessage(String body) {
		logger.info("MessageProcessor {}", body);
		ObjectMapper objectMapper = new ObjectMapper();
		Tutorial tutorial = null;
		try {
			tutorial = objectMapper.readValue(body, Tutorial.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tutorial;
		
	}
}
