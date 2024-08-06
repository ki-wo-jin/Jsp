package com.yedam.app.anotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// file:src/main/resources/applicationContext.xml
	
	
	Restaurant res = (Restaurant) ctx.getBean(Restaurant.class);
	
	res.run();
	}
}
