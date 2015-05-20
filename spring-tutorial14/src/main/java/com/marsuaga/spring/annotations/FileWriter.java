package com.marsuaga.spring.annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("filewriter")
public class FileWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to file "+text);
		
	}

}
