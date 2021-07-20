package com.aprio.auditlogservice.queue;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aprio.auditlogservice.model.Message;
import com.aprio.auditlogservice.service.Tutorialservice;

@Component
public class SendMessageToQueue extends RouteBuilder{

	@Autowired
	Message message;
	
	@Autowired
	Tutorialservice tutorialService;
	
	@Override
	public void configure() throws Exception {

		from("timer:active-mq-timer?period=1000")
		.transform().constant(" {\r\n" + 
				"        \"id\": 100,\r\n" + 
				"        \"title\": \"msgFromQueue\",\r\n" + 
				"        \"description\": \"msg reading from quere\",\r\n" + 
				"        \"published\": false\r\n" + 
				"    }\r\n" + 
				
				"")
		.to("activemq:logActive-mq");
		
		//from("activemq:logActive-mq")
		//.log(" ### :${body}")
		//.process(new MessageProcessor())
		//.to("log:received message");
		
		//.bean("discountService", "makeDiscount")
        //.to("jpa:org.apache.camel.example.spring.boot.rest.jpa.Discount")
        //.log("Created %${body.amount} discount for ${body.product.name}");
		
		//reading from queue, writing to db seperately working route
//		from("activemq:logActive-mq")
//		.to("log:${body}")
//		.bean(tutorialService, "getTutorial")
//		.to("jpa:com.aprio.auditlogservice.model.Tutorial")
//		.log("Created %${body} discount for========>");
		
		
		from("activemq:logActive-mq")
		.to("log:${body}")
		.bean(message, "getLogMessage")
		.to("jpa:com.aprio.auditlogservice.model.Tutorial")
		.log("Created %${body} discount for========>");

	}
	
	

}
