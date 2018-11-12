package com.knack.functional;

import java.util.List;

import org.apache.log4j.Logger;

import com.knack.model.Customer;

public class BeanLogger {
	final static Logger logger = Logger.getLogger(BeanLogger.class);

	public void logBean(List<Customer> cu) {

		logger.debug(cu);
	}
}
