package com.java8.parallel;

import java.util.concurrent.CompletableFuture;

public class AsyncInvoker {
	static final int sleepTimeInMillis = 1000;

	String threadLogName = null;
	public ServiceInvoker(){


		threadLogName = logName + "Rajesh";

	}
	public void invokeAsync() throws Exception {
		
	
		Log.debug("Processing ServiceInvoker. invokeAsync() ..start");
		CompletableFuture<Object> result = CompletableFuture.supplyAsync(() -> {
			System.err.println(" invokeAsync Start");
			Object m = null;
			
			try {
				m = getECIN();
			} catch (Exception e) {

				e.printStackTrace();
			} finally {

			}
			System.err.println(" invokeAsync End");
			return m;
		}).thenApply(m -> {
			try {
				m = processECIN(m);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
			return m;
		});

		Log.debug("Processing ServiceInvoker. invokeAsync() ..end");
	}

	private Object getECIN() throws Exception {
		
		Log.start(threadLogName + "getECIN.txt");  
		
		
        
        // Start the log
       // Log.start("getECIN-"+ batchLogName);  
      
        
		Object m = new Object("Policy");
		System.err.println(" getECIN Start"); 
		try {
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.err.println(" getECIN end");
		Log.debug("Processing ServiceInvoker. getECIN() ..end");
		Log.export();
		
		return m;
	}

	public Object processECIN(Object m) throws Exception {
		Log.start(threadLogName + "processECIN.txt");  
		Log.debug("Processing ServiceInvoker. processECIN() ..start");
		System.err.println(" processECIN Start");
		try {
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Log.debug("Processing ServiceInvoker. processECIN() ..end");
		System.err.println(" processECIN End");
		Log.export();
		return null;
	}

}
