package com.roger.concurrent.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface ConcurrentExecutorService {
	
	List<JSONObject> execute(List<JSONObject> queueList,String workExecutorName,String beanName);
}
