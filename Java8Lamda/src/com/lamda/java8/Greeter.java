package com.lamda.java8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Greeter {

	Add addFunction = (int a, int b)->{
		System.out.println("addFunction called");
		return (a+b);
		};   
	
		
	void callLambda(){
		System.out.println(addFunction.sum(1, 1));
	}
		

	public static void main(String[] args) {
		Greeter g = new Greeter();
		g.callLambda();
		
		
		Greeting greeting = () ->{
			System.out.println("Good Morning");
		};
	
		Add addFunction = (int a, int b)->{
			System.out.println("addFunction called");
			return (a+b);
			};   
		;

					
		
		int a[] = {10,20,30,1,2,3};
		IntStream.range(1, 10).skip(5).forEach(x->System.out.println(x));
		System.out.println(IntStream.range(1, 10).sum());
		
		//String name[] ={"Rajesh", "Kumar","Avre","Zser"};
		//Stream.of(name).sorted().forEach(x->System.out.println(x));;
	}

}
