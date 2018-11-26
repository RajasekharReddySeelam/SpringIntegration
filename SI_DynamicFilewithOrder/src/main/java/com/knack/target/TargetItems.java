package com.knack.target;

import java.util.Map;
/** Class used for hold all attributes listed in target.xml with values picked from Source with Order (single entry in the Target Form)**/
public class TargetItems {
	public Map<String, String> tItems;

	public Map<String, String> getcItems() {
		return tItems;
	}

	public void setcItems(Map<String, String> cItems) {
		this.tItems = cItems;
	}
}
