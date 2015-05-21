package com.marsuaga.spring.test15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/marsuaga/spring/beans/beans15.xml");
		Jungle jungle = (Jungle) context.getBean("jungle");
		System.out.println(jungle);
		// ((FileSystemXmlApplicationContext)context).close();
		((ClassPathXmlApplicationContext) context).close();

	}
}
