package com.roger.task.queue.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.roger.task.queue.QueueSelector;

@Component
public class QueueSelectorImpl implements QueueSelector {

	@Override
	public boolean hasNext() {
		return true;
	}
	
	@Override
	public List<String> findQueueNames() {
		List<String> queueNames = new ArrayList<>();
		queueNames.add("handleUser");
		queueNames.add("handleCustomer");
		return queueNames;
	}

	@Override
	public List<JSONObject> findByQueueName(String workExecutorName) {
		List<JSONObject> queueList = new ArrayList<>();

		JSONObject queue = new JSONObject();

		queue.put("queueName", workExecutorName);
		if (workExecutorName.equals("handleUser")) {
			queue.put("beanName", "userProcessor");
		}
		if (workExecutorName.equals("handleCustomer")) {
			queue.put("beanName", "customerProcessor");
		}

		queueList.add(queue);

		return queueList;
	}

}
