package com.marsuaga.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {
	//@Autowired
	private ConsoleWriter consoleWriter;
	//@Autowired
	private LogWriter fileWriter;
	
	
	/*@Autowired
	public Logger(ConsoleWriter consoleWriter,FileWriter fileWriter) {
		super();
		this.consoleWriter = consoleWriter;
		
	}*/

	@Autowired
	@Qualifier("toconsole")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	@Autowired
	@Qualifier("filewriter")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text){
		fileWriter.write(text);
	}
	public void writeConsole(String text){
		if(consoleWriter != null)
			consoleWriter.write(text);
	}
	
}
