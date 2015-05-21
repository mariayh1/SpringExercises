package com.marsuaga.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	//ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/marsuaga/spring/test/beans/beans.xml");
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/marsuaga/spring/test/beans/beans.xml");

    	Person person1 = (Person)context.getBean("person"); 
    	//Person person2 = (Person)context.getBean("person");
        person1.speak();
        person1.setTaxId(666); //prototype scope instead of singleton
        //System.out.println(person2);
        //Address address = (Address) context.getBean("address");
        
        Address address2 = (Address) context.getBean("address2");
        System.out.println(address2);
        System.out.println(person1);
        
        //((FileSystemXmlApplicationContext)context).close();
       ((ClassPathXmlApplicationContext)context).close();
    }
}
