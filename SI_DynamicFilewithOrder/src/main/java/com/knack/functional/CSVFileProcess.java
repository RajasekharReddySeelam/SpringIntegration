package com.knack.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.knack.model.RawItem;

public class CSVFileProcess {
	
	RawItem rawBean;
	List<String> keys;
	Map<String, String> beanMap;

	public List<RawItem> processFileToBean(String file) {
		List<RawItem> listDB=null;
		listDB = new ArrayList<RawItem>();
		String[] lines = file.split("\n");
		int i = 0;
			for (String line : lines) {
				
					if (i == 0 && line!=null) {
						setKeyToList(line);
						i++;
					} else if (line!=null) {
						List<String> values= setValuesToList(line);
						listDB.add(putKeysValuestoBean(values));
					}
			}
		return listDB;
	}

	private void setKeyToList(String line) {
		keys = splitLine(line);

	}

	private List<String> setValuesToList(String line) {
		List<String> values = splitLine(line);
		return values;
	}

	private List<String> splitLine(String line) {
		List<String> entries = Arrays.asList(line.split(","));
		return entries;
	}

	private RawItem putKeysValuestoBean(List<String> values) {
		int i = 0;
		beanMap = new HashMap<String, String>();
		for (String v : values) {
			beanMap.put(keys.get(i++).trim(), v.trim());
		}
		rawBean= new RawItem();
		rawBean.setAtbs(beanMap);
		return rawBean;
	}

}
