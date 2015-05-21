package com.marsuaga.spring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/marsuaga/spring/beans/beansspel.xml");
		Robot robot = (Robot)context.getBean("robot");
		robot.speak();
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
