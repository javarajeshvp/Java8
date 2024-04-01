package com.lamda.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * Refer : https://youtu.be/FH-FmcjEKnc?si=wa0HPaQJa3BD8fdR
 * @author rajeshvp
 *
 */
public class FunctionEg {
	static List<Integer> nos = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	public static void functionTestV1() {
		System.out.println("functionTestV1..");
		Function<Integer,Integer> f = new Function<Integer,Integer>() {

			@Override
			public Integer apply(Integer val) {
				
				return val * val;
			}

		};

		nos.stream().map(f).forEach(System.out::println);
	}

	public static void functionTestV2() {
		System.out.println("functionTestV2..");

		Function<Integer,Integer> p = n -> n *n ;

		nos.stream().map(p).forEach(System.out::println);
	}

	public static void functionTestV3() {
		System.out.println("functionTestV3..");
		nos.stream().map(n -> n * n).forEach(System.out::println);
	}

	public static void main(String[] args) {

		functionTestV1();
		functionTestV2();
		functionTestV3();
	}

}
