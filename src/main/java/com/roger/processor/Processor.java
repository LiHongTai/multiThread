package com.roger.processor;

import com.alibaba.fastjson.JSONObject;

public interface Processor {
	
	JSONObject process(JSONObject reqParam);
}
