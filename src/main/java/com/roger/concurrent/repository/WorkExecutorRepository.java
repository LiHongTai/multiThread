package com.roger.concurrent.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkExecutorRepository {
	
	private final ConcurrentHashMap<String, ThreadPoolExecutor> threadPoolExecutors;

	public WorkExecutorRepository() {
		threadPoolExecutors = new ConcurrentHashMap<>();
	}
	/**
	 *  延迟初始化单例模式
	 * @author Roger.Li
	 */
	private static class SingletonHandler{
		static final WorkExecutorRepository INSTANCE = new WorkExecutorRepository();
	}
	
	public static WorkExecutorRepository getInstance() {
		return SingletonHandler.INSTANCE;
	}
	
	public ThreadPoolExecutor lookup(String workExecutorName) {
		return threadPoolExecutors.get(workExecutorName);
	}
	
	public void bind(String workExecutorName,ThreadPoolExecutor threadPoolExecutor) {
		threadPoolExecutors.putIfAbsent(workExecutorName, threadPoolExecutor);
	}
	
	public void unbind(String workExecutorName) {
		threadPoolExecutors.remove(workExecutorName);
	}
}
