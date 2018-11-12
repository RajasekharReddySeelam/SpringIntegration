package com.knack.functional;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;

import com.knack.model.Customer;

public class FileProcess {
	String[] entry = null;

	Customer cu;

	public List<Customer> processFile(String file) {
		DOMConfigurator.configure("log4j.xml");
		List<Customer> list=new ArrayList<Customer>();
		String[] rows = file.split("\n");
		for (int i = 1; i < rows.length; i++) {
			String[] columns = rows[i].split(",");
			
			Customer cu=setCustomer(columns);
			list.add(cu);
		}
		return list;
	}

	public Customer setCustomer(String[] a) {
		Customer localCust = new Customer();
		localCust.setFirstName(a[0]);
		localCust.setLastName(a[1]);
		localCust.setCity(a[2]);
		localCust.setCountry(a[3]);
		return localCust;
	}
	
	
}