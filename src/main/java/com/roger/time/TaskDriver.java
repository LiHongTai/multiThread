package com.roger.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.roger.task.BaseTask;

@Component
public class TaskDriver {

	@Autowired
	private BaseTask baseTask;
	
	@Scheduled(cron="0/5 * * * * ?")
	public void run() {
		baseTask.start();
	}
}