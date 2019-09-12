package com.defaultmethod.java8;

public class MyGreeting implements Greeter{

	public void greet(){
		System.out.println("Christmas greetings....");
	}
	
	public static void main(String[] args) {
		MyGreeting greeting = new MyGreeting();
		greeting.greet();
	}

}
