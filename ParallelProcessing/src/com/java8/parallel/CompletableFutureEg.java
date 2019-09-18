package com.java8.parallel;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.baeldung.com/java-completablefuture
public class CompletableFutureEg {

	private int performTask() {

		try {
			// Thread.sleep(60000 * 3); // 3 minutes
			Thread.sleep(10000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return 10;
	}

	private void executeParallellyMethod1() {

		Instant before = Instant.now();

		CompletableFuture<Integer> a1 = CompletableFuture.supplyAsync(() -> performTask());
		CompletableFuture<Integer> a2 = CompletableFuture.supplyAsync(() -> performTask());
		CompletableFuture<Integer> a3 = CompletableFuture.supplyAsync(() -> performTask());

		CompletableFuture<Void> complete = CompletableFuture.allOf(a1, a2, a3);

		int result = Stream.of(a1, a2, a3).map(CompletableFuture::join)
				.collect(Collectors.summingInt(Integer::intValue));

		Instant after = Instant.now();
		long delta = Duration.between(before, after).toMillis(); // .toWhatsoever()

		System.out.println("Job Completed Parallelly executeParallellyMethod 1 : " + result);
		System.out.println(delta + " milli seconds");
		System.out.println(delta / 1000 + " seconds");
		System.out.println(delta / 1000 / 60 + " minutes");
	}

	private void executeSequencially() {

		Instant before = Instant.now();

		int a1 = performTask();
		int a2 = performTask();
		int a3 = performTask();

		Instant after = Instant.now();
		long delta = Duration.between(before, after).toMillis(); // .toWhatsoever()

		System.out.println("Job Completed Sequencially : " + (a1 + a2 + a3));

		System.out.println(delta + " milli seconds");
		System.out.println(delta / 1000 + " seconds");
		System.out.println(delta / 1000 / 60 + " minutes");

	}

	public static void main(String[] args) {
		CompletableFutureEg cfEg = new CompletableFutureEg();
		cfEg.executeSequencially();
		cfEg.executeParallellyMethod1();

	}

}
