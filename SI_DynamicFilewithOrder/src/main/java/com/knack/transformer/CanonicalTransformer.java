package com.knack.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.knack.canonical.Canonical;
import com.knack.canonical.CanonicalItem;
import com.knack.model.RawItem;

public class CanonicalTransformer {

	@Resource
	Canonical canonicalItemsBean;

	CanonicalItem cItem;

	public List<CanonicalItem> transformToCanonical(List<RawItem> rawItemList) {

		List<CanonicalItem> cItemList = new ArrayList<>();
		for (RawItem rawItem : rawItemList) {
			CanonicalItem formatedCanonical = canonicalFormatter(rawItem);
			cItemList.add(formatedCanonical);
		}
		return cItemList;
	}

	private CanonicalItem canonicalFormatter(RawItem rawItem) {
		cItem = new CanonicalItem();
		cItem.setcAttribute(pickAttributes(rawItem));
		return cItem;
	}

	private Map<String, String> pickAttributes(RawItem rawItem) {
		Map<String, String> canoicalMap = new HashMap<>();
		for (String s : canonicalItemsBean.getAttribute()) {
			if (rawItem.getAtbs().get(s) != null) {
				canoicalMap.put(s, rawItem.getAtbs().get(s));
			} else
				canoicalMap.put(s, "--Not Available--");
		}
		return canoicalMap;
	}

}
