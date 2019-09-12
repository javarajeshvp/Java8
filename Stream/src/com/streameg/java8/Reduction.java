package com.streameg.java8;

import java.util.ArrayList;
import java.util.List;

import com.streameg.java8.to.Person;

public class Reduction {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(10,"A",Person.Sex.MALE));
		persons.add(new Person(11,"B",Person.Sex.MALE));
		persons.add(new Person(10,"D",Person.Sex.MALE));
		persons.add(new Person(11,"E",Person.Sex.MALE));
		persons.add(new Person(20,"H",Person.Sex.MALE));
		persons.add(new Person(17,"I",Person.Sex.MALE));
		
		persons.add(new Person(12,"C",Person.Sex.FEMALE));
		persons.add(new Person(12,"F",Person.Sex.FEMALE));
		persons.add(new Person(14,"G",Person.Sex.FEMALE));
		persons.add(new Person(8,"J",Person.Sex.FEMALE));
		double average = persons
			    .stream()
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
				System.out.println("Average Age "+ average);
	}

}
