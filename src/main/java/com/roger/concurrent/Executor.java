package com.roger.concurrent;

import java.util.concurrent.Callable;

import com.alibaba.fastjson.JSONObject;
import com.roger.processor.Processor;

public class Executor implements Callable<JSONObject> {

	private Processor processor;
	private JSONObject queue;
	
	public Executor(Processor processor, JSONObject queue) {
		super();
		this.processor = processor;
		this.queue = queue;
	}



	@Override
	public JSONObject call() throws Exception {
		JSONObject reqParam = queue.getJSONObject("reqParam");
		return processor.process(reqParam);
	}

}
