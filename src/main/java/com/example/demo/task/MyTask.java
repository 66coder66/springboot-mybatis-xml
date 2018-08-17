package com.example.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Scheduled(cron = "0/10 * * * * ?") // 每5秒执行一次
	public void scheduler() {
	   logger.info(">>>>>>>>>>>>> scheduled test... ");
	}
}
