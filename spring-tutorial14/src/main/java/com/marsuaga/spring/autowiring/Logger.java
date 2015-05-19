package com.marsuaga.spring.autowiring;

public class Logger {
	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;
	
	public Logger() {
		super();
	}

	public Logger(ConsoleWriter consoleWriter, FileWriter fileWriter) {
		super();
		this.consoleWriter = consoleWriter;
		this.fileWriter = fileWriter;
	}

	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text){
		fileWriter.write(text);
	}
	public void writeConsole(String text){
		consoleWriter.write(text);
	}
	
}
