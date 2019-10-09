package com.java8.parallel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

// https://www.baeldung.com/java-completablefuture
public class CompletableFutureFileEg {

	private long sleepTimeInMillis = 1; // 60000 = 1 minute

	public static void main(String[] args) {
		CompletableFutureFileEg cfEg = new CompletableFutureFileEg();
		cfEg.executeParallelly();

	}

	private void write(String s) {

		try {
			Files.write(Paths.get("C:/dvlp/Example/output.txt"), s.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void executeParallelly() {

		Instant before = Instant.now();

		List<String> inputMessages = Arrays.asList("a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b",
				"C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a",
				"b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b",
				"C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "C", "a", "b",
				"C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a",
				"b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a",
				"b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b",
				"C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b",
				"C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a",
				"b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b",
				"C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "C", "a", "b", "C", "a", "b",
				"C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a", "b", "C",
				"a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b", "C", "a",
				"b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "a", "b",
				"C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b",
				"a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C", "a", "b", "C",
				"a", "b", "C");
		List<CompletableFuture<String>> inputStream = inputMessages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> {
					// System.out.println("Doing Header");
					return updateHeader(s);
				}).thenApplyAsync(s -> {
					// System.out.println("Doing Body");
					return updateBody(s);
				}).thenApplyAsync(s -> {
					// System.out.println("Doing Footer");
					return updateFooter(s);
				})).collect(Collectors.toList());

		CompletableFuture<Void> allOf = CompletableFuture
				.allOf(inputStream.toArray(new CompletableFuture[inputStream.size()])).whenComplete((v, th) -> {
					inputStream.forEach(cf -> {
						System.out.println("Result here : " + cf.getNow("No value"));
						write(cf.getNow("No value"));
					});

				});
		allOf.join();

		Instant after = Instant.now();
		long delta = Duration.between(before, after).toMillis();

		System.out.println("Job Completed executeParallellyMethod 3 : ");

		System.out.println(delta + " milli seconds");
		System.out.println(delta / 1000 + " seconds");
		System.out.println(delta / 1000 / 60 + " minutes");
	}

	private String updateBody(String s) {
		System.err.println("Called updateBody()");
		try {
			// Thread.sleep(60000 * 3); // 3 minutes
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return s + " Body goes here\n";
	}

	private String updateFooter(String s) {
		System.err.println("Called updateFooter()");
		try {
			// Thread.sleep(60000 * 3); // 3 minutes
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return s + " Footer goes here\n";
	}

	private String updateHeader(String s) {
		System.err.println("Called updateHeader()");
		try {
			// Thread.sleep(60000 * 3); // 3 minutes
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		return s + " Header goes here \n";
	}

}
