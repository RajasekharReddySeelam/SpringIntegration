package com.knack.canonical;

import java.util.Map;

/** Class used for hold all attributes listed in canonical.xml with values picked from Source (single entry in the Canonical Form)**/
public class CanonicalItem {
	
	public Map<String, String> cAttribute;

	public Map<String, String> getcAttribute() {
		return cAttribute;
	}

	public void setcAttribute(Map<String, String> cAttribute) {
		this.cAttribute = cAttribute;
	}
	
}