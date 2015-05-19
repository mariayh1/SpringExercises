package com.marsuaga.spring.test14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/marsuaga/spring/beans/beans.xml");

    	FruitBasket basket = (FruitBasket)context.getBean("basket"); 
    	System.out.println(basket);
        
        //((FileSystemXmlApplicationContext)context).close();
       ((ClassPathXmlApplicationContext)context).close();
    }
}
