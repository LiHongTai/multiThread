package com.roger.processor.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.roger.processor.Processor;

@Service(value="customerService")
public class CustomerProcessor implements Processor {

	@Override
	public JSONObject process(JSONObject reqParam) {
		System.out.println("进入客户处理流程....");
		return null;
	}

}
