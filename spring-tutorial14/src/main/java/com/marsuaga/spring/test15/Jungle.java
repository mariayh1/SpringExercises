package com.marsuaga.spring.test15;

import java.util.HashMap;
import java.util.Map;

public class Jungle {
	private Animal largest;
	
	private Map<String, String> foods = new HashMap<String, String>();
	private Map<String, Animal> animals = new HashMap<String, Animal>();
	
	public void setFoods(Map<String, String> foods){
		this.foods=foods;
	}
	public void setAnimals(Map<String, Animal> animals){
		this.animals= animals;
	}
	public Animal getLargest() {
		return largest;
	}
	public void setLargest(Animal largest) {
		this.largest = largest;
	}
	@Override
	public String toString() {
		return "Jungle [largest=" + largest + ", foods=" + foods + ", animals="
				+ animals + "]";
	}
	

	
	
	
	

}
