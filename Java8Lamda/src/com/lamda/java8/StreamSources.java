package com.lamda.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.lamda.java8.to.User;

public class StreamSources {

	
	public static Stream<User> userStream(){
		
		return Stream.of( 
				new User(1,"Lione","Mess"),
				new User(2,"Kester","Ytre"),
				new User(3,"LOU","KUT"),
				new User(4,"ABC","Hes"),
				new User(5,"Mark","Hord"),
				new User(6,"Kumar","Nnhd")
				);
	}
	
	
	public static Stream<String> stringNumbersStream(){
		
		return Stream.of("One","Two","Three","Four","Five");
	}
	public static Stream<Integer> intNumbersStream(){
		
	//return Stream.of(1,2,3,4,5);
		return Stream.iterate(0, i->i+2).limit(5);
		
	}
	
	
	public static void main(String[] args) {
		
		List<User> names= intNumbersStream().flatMap(id->userStream().filter(user-> user.getUserId()==id)).collect(Collectors.toList());
		
		System.out.println(names);
		//intNumbersStream().flatMap(id->userStream().filter(user-> user.getUserId()==id)).forEach(System.out::print);;
		//userStream().map(u->u.getFirstName()).forEach(System.out::println);
		
		
	//	intNumbersStream().forEach(System.out::println);
	}

}
