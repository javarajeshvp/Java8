package com.lamda.java7;

public interface Greeting {
	public  void perform ();
	default void defaultMethod(){
		System.out.println("Default methode");
	}
	static void staicMethod(){
		System.out.println("************staicMethod ******************");
	}

} 

