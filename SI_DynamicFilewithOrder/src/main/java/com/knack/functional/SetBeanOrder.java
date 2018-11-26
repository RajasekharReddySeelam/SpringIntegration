package com.knack.functional;

import java.util.List;

import javax.annotation.Resource;

import com.knack.orderBean.Attributes;

public class SetBeanOrder {
	
	@Resource
	Attributes orderBean;
		public void setOrder(String file) {
			
		}
		
		public void displayOrderList(Attributes ab) {
			List<String>list= orderBean.getAttribute();
			for(String s: list) {
				System.out.println("Attribue : "+s);
			}
		}
}
