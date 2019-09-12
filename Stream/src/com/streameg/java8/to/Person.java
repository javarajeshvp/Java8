package com.streameg.java8.to;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int age;
	private String name;
	private Sex gender;
	
	public Person(int age, String name, Sex gender){
		this.age=age;
		this.name = name;
		this.gender=gender;
		
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public enum Sex 
    { 
        MALE, FEMALE; 
    } 
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
