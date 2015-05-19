package com.marsuaga.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/marsuaga/spring/beans/beansAutowiring.xml");
		Logger logger = (Logger) context.getBean("logger");
		logger.writeConsole("Hello from console");
		logger.writeFile("Hello from file");
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
