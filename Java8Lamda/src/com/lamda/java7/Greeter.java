package com.lamda.java7;

public class Greeter {

	public  void greet (Greeting greeting){
		greeting.perform();
		greeting.defaultMethod();
		Greeting.staicMethod();
	}
	
	public static void main(String arg[]){
		Greeter greeter = new Greeter();
		Greeting greeting = new GreetingGoodMorningImpl();
		greeter.greet(greeting);
		greeting = new GreetingGoodNightImpl();
		greeter.greet(greeting);
	}
}
