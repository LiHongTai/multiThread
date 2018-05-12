package com.roger.task.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.roger.concurrent.service.ConcurrentExecutorService;
import com.roger.task.BaseTask;
import com.roger.task.queue.QueueSelector;

@Component
public class BaseTaskImpl implements BaseTask {

	@Autowired
	private ConcurrentExecutorService concurrentExecutorService;

	@Autowired
	private QueueSelector queueSelector;
	
	@Override
	public void start() {
		before();

		if (!shouldStart())
			return;

		List<JSONObject> resultList = new ArrayList<>();

		List<String> queueNames = queueSelector.findQueueNames();
		queueNames.forEach((queueName) -> {
			List<JSONObject> queueList = queueSelector.findByQueueName(queueName);
			String beanName = queueList.get(0).getString("beanName");
			resultList.addAll(concurrentExecutorService.execute(queueList, queueName, beanName));
		});

		after(resultList);

	}
	
	/**
	 * 检查是否有待执行的任务，如果没有任务，则无需启动任务
	 */
	private boolean shouldStart() {
		return queueSelector.hasNext();
	}

	private void before() {

	}

	private void after(List<JSONObject> resultList) {
		
	}

}
