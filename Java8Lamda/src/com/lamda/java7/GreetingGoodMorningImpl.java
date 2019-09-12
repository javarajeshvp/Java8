package com.lamda.java7;

public class GreetingGoodMorningImpl implements Greeting {
	public void perform() {
		System.out.println("Good Morning");
	}
	
	public void defaultMethod(){
		System.out.println("Default methode GreetingGoodMorningImpl");
	}
}
