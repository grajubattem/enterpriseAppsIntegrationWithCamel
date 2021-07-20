package com.aprio.auditlogservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aprio.auditlogservice.model.Message;

@Component
public class MyFirstTimerRouter extends RouteBuilder{

	@Autowired
	Message message;
	
	@Override
	public void configure() throws Exception {
		//timer
		//transformation
		//log
		
//		from("timer:first-timer")
//		.transform().constant("My Constant Message="+LocalDateTime.now())
//		.to("log:first-timer");
		
//		from("timer:first-timer")
//		.to("log:${body}")
//		.bean(message, "getLogMessage")
//		.to("log:first-timer");
		
//		from("timer:first-timer")
//		.log("${body}")
//		.transform().constant("My Constant Message="+LocalDateTime.now())
//		.log("${body}")
//		.bean(message, "getLogMessage")
//		.log("${body}")
//		.process(new MessageProcessor())
//		.log("${body}")
//		.to("log:first-timer");
		
		
	}

}
