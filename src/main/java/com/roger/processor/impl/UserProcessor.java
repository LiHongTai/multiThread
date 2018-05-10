package com.roger.processor.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.roger.processor.Processor;

@Service(value = "userProcessor")
public class UserProcessor implements Processor {

	@Override
	public JSONObject process(JSONObject reqParam) {
		System.out.println("进入用户处理流程....");
		return null;
	}

}
