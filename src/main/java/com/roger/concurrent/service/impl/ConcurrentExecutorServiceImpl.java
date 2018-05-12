package com.roger.concurrent.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.roger.concurrent.Executor;
import com.roger.concurrent.service.ConcurrentExecutorService;
import com.roger.concurrent.service.WorkManagementService;
import com.roger.processor.Processor;
import com.roger.utils.SpringContextUtil;

@Service
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ConcurrentExecutorServiceImpl implements ConcurrentExecutorService {

	@Autowired
	private WorkManagementService workManagementService;

	@Override
	public List<JSONObject> execute(List<JSONObject> queueList, String workExecutorName, String beanName) {
		ExecutorService executorService = workManagementService.getExecutorService(workExecutorName);
		CompletionService completionService = new ExecutorCompletionService<>(executorService);
		Processor processor = (Processor) SpringContextUtil.getBean(beanName);
		queueList.forEach((queue) -> {
			Executor executor = new Executor(processor, queue);
			completionService.submit(executor);
		});

		List<JSONObject> resultList = new ArrayList<>();

		queueList.forEach((queue) -> {
			try {
				JSONObject result = (JSONObject) completionService.take().get();
				if (result != null && !result.isEmpty())
					resultList.add(result);
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		});

		return resultList;

	}

}
