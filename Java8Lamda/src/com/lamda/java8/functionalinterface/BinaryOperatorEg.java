package com.lamda.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * 
 * Refer : https://youtu.be/FH-FmcjEKnc?si=wa0HPaQJa3BD8fdR
 * 
 * @author rajeshvp
 *
 */
public class BinaryOperatorEg {
	static List<Integer> nos = Arrays.asList(3, 10, 2, 8, 5, 11, 7, 4, 9,10);

	public static void boTestV1() {
		System.out.println("boTestV1..");
		BinaryOperator<Integer> bo = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer arg0, Integer arg1) {

				return arg0 + arg1;
			}

		};

		int val = nos.stream().reduce(0, bo).intValue();
		System.out.println(val);
	}

	public static void boTestV2() {
		System.out.println("boTestV2..");
		BinaryOperator<Integer> bo = (a, b) -> a + b;
		int val = nos.stream().reduce(0, bo).intValue();
		System.out.println(val);

	}

	public static void boTestV3() {
		System.out.println("boTestV3..");
		int val = nos.stream().reduce(0, (a, b) -> a + b).intValue();
		System.out.println(val);
	}

	public static void main(String[] args) {

		boTestV1();
		boTestV2();
		boTestV3();
		System.out.println("Not sorted");
		nos.stream().forEach(System.out::println);
		System.out.println("Sorted");
		nos.stream().sorted().forEach(System.out::println);
		
	}

}
