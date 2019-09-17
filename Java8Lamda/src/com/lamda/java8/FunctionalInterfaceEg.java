package com.lamda.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceEg {

	public static void main(String[] args) {

		List<Message> messageList = new ArrayList<Message>();
		messageList.add(new Message(10, "Message 10", "Low", new Author("Rajesh")));
		messageList.add(new Message(11, "Message 11", "Low", new Author("Rajesh")));
		messageList.add(new Message(12, "Message 12 ", "Low", new Author("Rajesh1")));
		messageList.add(new Message(13, "Message 13 ", "High", new Author("Rajesh1")));
		messageList.add(new Message(14, "Message 14", "High", new Author("Rajesh1")));
		messageList.add(new Message(15, "Message 15", "Medium", new Author("Rajesh")));
		
		  Predicate<Message> predicate = m -> m.getId() == 11 ; // One way to assign 
		  pintOnCondition(messageList,predicate );
		 
		/*
		 * //System.out.println("Condition 1 "); //pintOnCondition(messageList,
		 * m -> m.getId() > 11 ); System.out.println("Condition 2 ");
		 * pintOnCondition(messageList, m -> m.getId() <= 12 &&
		 * m.getPriority().equals("Low") ); //pintOnCondition(messageList, m ->
		 * m.getId() <= 12 && m.getPriority().equals("Low") );
		 * System.out.println("Condition 3 "); BiPredicate<Message,Author>
		 * biPredicate = (m,a) -> m.getId() >= 11 &&
		 * a.getName().equals("Rajesh");
		 * pintOnCondition(messageList,biPredicate);
		 */

		Function<Integer, String> function = t -> {
			if (t / 2 == 0)
				return t + " is Even No";
			else {
				return t + " is Odd No";
			}
		};
		
		Function<Integer, Integer> function1 = t -> t*2;
		Function<Integer, Integer> function2 = t -> t*2;
		Function<Integer, Integer> function3 = t -> t + 100;
		/*
		 
		System.out.println(function.apply(7));
		System.out.println(function1.andThen(function2).andThen(function3).apply(4));
		System.out.println(function1.compose(function2).compose(function3).apply(4));
		
		*/
		
		   // This function returns a random value. 
        Supplier<Integer> randomValue = () -> Math.min(10, 20); 
  
        System.out.println("Normal " +Math.min(10, 20)); 
        // Print the random value using get() 
        System.out.println(randomValue.get()); 
        
		
	}

	private static void pintOnCondition(List<Message> messages, Predicate<Message> predicate) {
		messages.stream().filter(m -> predicate.test(m)).forEach(m -> System.out.println(m.getMessage()));
		/*
		 * for (Message m : messages) { if (predicate.test(m)) {
		 * System.out.println(m.getMessage()); } }
		 */
	}

	private static void pintOnCondition(List<Message> messages, BiPredicate<Message, Author> biPredicate) {
		messages.stream().filter(m -> biPredicate.test(m, m.getAuthor()))
				.forEach(m -> System.out.println(m.getMessage()));

	}
}
