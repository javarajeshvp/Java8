package com.lamda.java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Greeter {

	public static void main(String[] args) {
		
		Greeting greeting = () ->{
			System.out.println("Good Morning");
		};
		
		Add addFunction = (int a, int b)->a+b;   
	//	System.out.println(addFunction.foo(10, 20));
		/*
		// Some lamda expressions
		()->System.out.println("Hello lamda");
		doubleNumber = (int a)-> a*2;
		addFunction = (int a, int b) -> a+b;
		divideFunction = (int a, int b) -> {
			if(a==0) return 0;
			else return a/b; 
			
				
					}; 
					
		
		int a[] = {10,20,30,1,2,3};
		IntStream.range(1, 10).skip(5).forEach(x->System.out.println(x));
		System.out.println(IntStream.range(1, 10).sum());
		*/
		String name[] ={"Rajesh", "Kumar","Avre","Zser"};
		Stream.of(name).sorted().forEach(x->System.out.println(x));;
	}

}
