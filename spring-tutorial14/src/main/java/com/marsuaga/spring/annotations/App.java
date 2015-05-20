package com.marsuaga.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/marsuaga/spring/beans/beansAnnotations.xml");
		Logger logger = (Logger) context.getBean("logger");
		logger.writeConsole("Hello from console");
		logger.writeFile("Hello from file");
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
