package com.roger.time;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.roger.BaseTestSuitCase;

public class TaskDriverTest extends BaseTestSuitCase{

	@Autowired
	private TaskDriver taskDriver;
	
	@Test
	public void testRun() {
		taskDriver.run();
		while(true) {
			
		}
	}
}
