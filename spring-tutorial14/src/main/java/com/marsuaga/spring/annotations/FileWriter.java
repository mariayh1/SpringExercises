package com.marsuaga.spring.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("filewriter")
public class FileWriter implements LogWriter{

	public void write(String text) {
		System.out.println("Write to file "+text);
		
	}

}
