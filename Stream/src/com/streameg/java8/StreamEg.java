package com.streameg.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamEg {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		names.add("Test1");
		names.add("Aest1");
		names.add("ATest2");
		names.add("Test3");

		Stream<String> nameStream = names.stream();
		nameStream.filter(name -> name.startsWith("T")).forEach(name -> {
			System.out.println(name);
		});
		
	//	nameStream.forEach(System.out::println);
		
	}

}
