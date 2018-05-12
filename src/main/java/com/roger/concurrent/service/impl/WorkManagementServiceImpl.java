package com.roger.concurrent.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roger.concurrent.factory.WorkExecutorFactory;
import com.roger.concurrent.service.WorkManagementService;

@Service
public class WorkManagementServiceImpl implements WorkManagementService{

	@Autowired
	private WorkExecutorFactory factory;
	
	@Override
	public void submitWork(String workExecutorName, Runnable task) {
		ExecutorService executorService = factory.getExecutorService(workExecutorName);
		if(executorService == null) {
			throw new RuntimeException();
		}
		executorService.submit(task);
	}

	@Override
	public <T> Future<T> submitFutureWork(String workExecutorName, Callable<T> task) {
		ExecutorService executorService = factory.getExecutorService(workExecutorName);
		if(executorService == null) {
			throw new RuntimeException();
		}
		return executorService.submit(task);
	}

	@Override
	public ExecutorService getExecutorService(String workExecutorName) {
		ExecutorService executorService = factory.getExecutorService(workExecutorName);
		if(executorService == null) {
			throw new RuntimeException();
		}
		return executorService;
	}

}
