package com.knack.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.knack.canonical.CanonicalItem;
import com.knack.target.Target;
import com.knack.target.TargetItems;

public class TargetTransformer {

	@Resource
	Target targetBean;

	TargetItems tItems;

	public Message<List<TargetItems>> transformToTarget(List<CanonicalItem> cItemList) {
		Message<List<TargetItems>> message;

		List<TargetItems> tItemList = new ArrayList<>();
		for (CanonicalItem cItem : cItemList) {
			tItems = targetFormatter(cItem);
			tItemList.add(tItems);
		}
		message = MessageBuilder.withPayload(tItemList).setHeader("OutFormat", targetBean.getType()).build();
//		messageChannel.send(message);
		return message;
	}

	private TargetItems targetFormatter(CanonicalItem cItem) {
		TargetItems tItem = new TargetItems();
		tItem.setcItems(pickFromCanonical(cItem));
		return tItem;
	}

	private Map<String, String> pickFromCanonical(CanonicalItem cItem) {
		Map<String, String> targetMap = new HashMap<>();
		for (String s : targetBean.getAttribute()) {
			targetMap.put(s, cItem.getcAttribute().get(s));
			System.out.println(s+" : "+cItem.getcAttribute().get(s));
		}
		return targetMap;
	}
}
