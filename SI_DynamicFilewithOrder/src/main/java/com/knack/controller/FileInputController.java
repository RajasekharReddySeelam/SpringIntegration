package com.knack.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileInputController {

	@Resource
	MessageChannel fileCarrier;
	final static Logger logger = Logger.getLogger(FileInputController.class);

	@RequestMapping(value = "/submit")
	public ResponseEntity<String> testMethod(@RequestBody String fileBinary) {
		DOMConfigurator.configure("log4j.xml");
		try {
			if (fileBinary != null) {
				Message<String> message = MessageBuilder.withPayload(fileBinary).build();
				fileCarrier.send(message);
				logger.debug("message Sent");
				return new ResponseEntity<>("Success", HttpStatus.OK);
			} else {
				logger.error("file not found try again..!");
				return ResponseEntity.badRequest().body("file not found");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).body("something Went wrong ");
		}
		
	}

}
