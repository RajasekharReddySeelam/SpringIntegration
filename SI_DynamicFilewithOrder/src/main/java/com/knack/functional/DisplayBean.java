package com.knack.functional;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.knack.model.RawItem;
import com.knack.orderBean.Attributes;

public class DisplayBean {
	Attributes ab;
	RawItem dBean;
	final static Logger logger = Logger.getLogger(DisplayBean.class);
	
	public void displayBean(RawItem bean) {
		dBean=bean;
		Map<String, String> disp = bean.getAtbs();
		for (Map.Entry<String, String> entry : disp.entrySet()) {
			logger.info("Entry > " + entry.getKey() + " : " + entry.getValue());
		}
		List<String> keys = ab.getAttribute();
		if (CheckOrderAttributes()) {
			for (String s : keys) {
				logger.debug("InOrder > " + s + " : " + disp.get(s));
			}
		}
	}

	private boolean CheckOrderAttributes() {
		boolean flag = true;
		for (String beanSource : dBean.getAtbs().keySet() ) {
			if (!ab.getAttribute().contains(beanSource)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public void displayAttributes(Attributes attr) {
		ab = attr;
	}
}
