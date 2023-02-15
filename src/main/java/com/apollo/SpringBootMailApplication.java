package com.apollo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
public class SpringBootMailApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootMailApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootMailApplication.class, args);
		ctx.addApplicationListener((ApplicationListener<ContextClosedEvent>) applicationEvent -> logger.info("一共发送： " + SpringBootRunner.COUNT + "封邮件"));
	}

}
