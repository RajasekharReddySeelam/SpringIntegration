package com.knack.model;

import java.util.HashMap;
import java.util.Map;
  /** Class used for read Raw data Entry (single entry in the File)**/
public class RawItem {
	
	Map<String,	String> atbs=new HashMap<String, String>();

	public Map<String, String> getAtbs() {
		return atbs;
	}

	public void setAtbs(Map<String, String> atbs) {
		this.atbs = atbs;
	}

}