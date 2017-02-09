package com.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

	public static void main(String args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		ClientThread[] clientThreads = new ClientThread[] {
			new ClientThread("Alice", executorService),
			new ClientThread("Bobby", executorService),
			new ClientThread("chris", executorService)
		};

		for (ClientThread clientThread: clientThreads) {
			clientThread.start();
		}
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		for (ClientThread clientThread: clientThreads) {
			clientThread.stopThread();
		}
		executorService.shutdown();
	}

}
