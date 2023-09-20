package com.giulio.sannino.bean;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AppConfigurazione {
	
	 @Bean(name = "asyncExecutor")
	    public TaskExecutor asyncExecutor() {
		 ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
		 executor.setCorePoolSize(1);
	        executor.setMaxPoolSize(10);
	        executor.setQueueCapacity(20);
	        executor.setThreadNamePrefix("Async-");
	        executor.initialize();
	        return executor;
	    }

}
