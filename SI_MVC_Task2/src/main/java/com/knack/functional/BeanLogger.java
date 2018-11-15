package com.knack.functional;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import com.knack.jaxb.Order;
import com.knack.model.Customer;

public class BeanLogger {
	final static Logger logger = Logger.getLogger(BeanLogger.class);

	Order order;

	public void logBean(Customer cu)  {

		String[] fieldOrder = order.getArray();
		for (int i = 0; i < fieldOrder.length; i++) {
			Field field;
			try {
				field = Customer.class.getField(fieldOrder[i]);
				logger.debug(fieldOrder[i] + " : " + field.get(cu));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setOrderValue(Order o) {
		order = o;
	}
}
