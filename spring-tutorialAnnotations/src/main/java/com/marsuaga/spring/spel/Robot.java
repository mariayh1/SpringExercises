package com.marsuaga.spring.spel;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	private String id = "Default robot";
	private String speech = "hello";
	
	public void speak(){
		System.out.println(id+ ":"+speech);
	}
	
	@Autowired
	//"#{randomText.getText()?.length()}"
	public void setId(@Value("${jdbc.user}")String id) {
		this.id = id;
	}
	//SPEL operations
	@Autowired
	//"#{new java.util.Date().toString()}"
	//"#{T(Math).PI}"
	//"#{T(Math).sin(5)}"
	//"#{T(Math).sin(T(Math).PI/4)}"
	//#{T(Math).sin(T(Math).PI/4)^2 le 0.8 ? 'yes':'no'}
	//Using property files
	public void setSpeech(@Value("${jdbc.password}")String speech) {
		this.speech = speech;
	}
	
}
