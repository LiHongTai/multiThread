package com.roger.concurrent.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public interface WorkManagementService {

	void submitWork(String workExecutorName,Runnable task);
	
	<T> Future<T> submitFutureWork(String workExecutorName, Callable<T> task);
	
	ExecutorService getExecutorService(String workExecutorName);
}
