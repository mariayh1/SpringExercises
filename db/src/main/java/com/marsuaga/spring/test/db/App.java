package com.marsuaga.spring.test.db;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/marsuaga/spring/beans/beansDB.xml");
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		List<Offer> offers = offersDao.getOffers();
		for(Offer offer: offers){
			System.out.println(offer);
		}
		((ClassPathXmlApplicationContext) context).close();
    }
}
