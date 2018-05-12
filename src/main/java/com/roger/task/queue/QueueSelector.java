package com.roger.task.queue;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface QueueSelector {

	boolean hasNext();
	
	List<String> findQueueNames();

	List<JSONObject> findByQueueName(String workExecutorName);
}
