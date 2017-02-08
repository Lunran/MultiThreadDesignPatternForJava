package com.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

	public static void main(String args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		try {
			new ClientThread("Alice", executorService).start();
			new ClientThread("Bobby", executorService).start();
			new ClientThread("Chris", executorService).start();
			Thread.sleep(5000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		finally {
			executorService.shutdown();
		}
	}

}
