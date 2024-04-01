package com.lamda.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * Refer : https://youtu.be/FH-FmcjEKnc?si=wa0HPaQJa3BD8fdR
 * 
 * @author rajeshvp
 *
 */
public class PredicateEg {
	static List<Integer> nos = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	public static void predicateTestV1() {
		System.out.println("predicateTestV1..");

		Predicate<Integer> p = new Predicate<Integer>() {

			@Override
			public boolean test(Integer val) {

				return val % 2 == 0;
			}

		};

		nos.stream().filter(p).forEach(System.out::println);
	}

	public static void predicateTestV2() {
		System.out.println("predicateTestV2..");

		Predicate<Integer> p = n -> n % 2 == 0;

		nos.stream().filter(p).forEach(System.out::println);
	}

	public static void predicateTestV3() {
		System.out.println("predicateTestV3..");
		nos.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
	}

	public static void main(String[] args) {

		predicateTestV1();
		predicateTestV2();
		predicateTestV3();
	}

}
