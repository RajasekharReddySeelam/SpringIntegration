package com.knack.functional;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class BeanSplitter {
	@Resource
	MessageChannel rawUnitChannel;

	public void split(Message<List<Object>> input) {
		List<Object> objects = input.getPayload();

		for (Object object : objects) {
			Message<Object> message = MessageBuilder.withPayload(object).build();

			rawUnitChannel.send(message);
		}
	}
}