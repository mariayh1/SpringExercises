package com.marsuaga.spring.test.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/marsuaga/spring/beans/beansDB.xml");
		OffersDAO offersDao = (OffersDAO)context.getBean("offersDao");
		Offer updateOffer= new Offer(9, "Claire", "claire@gmail.com", "Web design");
		if(offersDao.update(updateOffer)){
			System.out.println("Updated object");
		}
		
		try {
			
			List<Offer> offersList = new ArrayList<Offer>();
			
			offersList.add(new Offer(3, "Maria", "mariayh@gmail.com", "Cash for software"));
			offersList.add(new Offer(2, "Manolo", "mmm@gmail.com", "Data analytics"));
			int[]rvals=offersDao.create(offersList);
			for(int value:rvals){
				System.out.println("Updated "+value+" rows.");
			}
			
			/*Offer offer1 = new Offer("Dave", "dave@cv.com", "Coding Java");
			Offer offer2 = new Offer("Pepa", "pepa@cv.com", "Sw testing");
			if(offersDao.create(offer1)){
				System.out.println("Created offer object");
			}
			if (offersDao.create(offer2)){
				System.out.println("Created offer object");
			}
			offersDao.delete(3);
			Offer offer = (Offer) offersDao.getOffer(4);
			System.out.println("Should be Manolo "+ offer);*/
		
		}
		catch(CannotGetJdbcConnectionException ex){
			System.out.println("Cannot get database connection.");
		}
		catch (DataAccessException ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}
		
		((ClassPathXmlApplicationContext) context).close();
    }
}
