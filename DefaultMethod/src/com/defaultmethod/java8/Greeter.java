package com.defaultmethod.java8;

public interface Greeter {

	public default void greet(){
		System.out.println("Seasonal greetings....");
	}
}
