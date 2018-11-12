package com.knack.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileInputController {

	@Resource
	MessageChannel fileAsMessage;
	final static Logger logger = Logger.getLogger(FileInputController.class);

	@RequestMapping(value = "/submit")
	public String testMethod(@RequestBody String fileBinary) {

		try {
			logger.info("Authorization Success");
			if (fileBinary != null) {
				Message<String> message = MessageBuilder.withPayload(fileBinary).build();

				fileAsMessage.send(message);
			} else {
				logger.error("file not found try again..!");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "success";
	}

}
