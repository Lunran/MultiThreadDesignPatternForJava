package com.sample;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ClientThread extends Thread {

	private final ExecutorService executorService;
	private static final Random random = new Random();
	private volatile boolean terminated = false;

	public ClientThread(String name, ExecutorService executorService) {
		super(name);
		this.executorService = executorService;
	}

	public void run() {
		try {
			for (int i=0; !terminated; i++) {
				try {
					Request request = new Request(getName(), i);
					executorService.execute(request);
					Thread.sleep(random.nextInt(1000));
				}
				catch (InterruptedException ie) {
					terminated = true;
				}
				catch (RejectedExecutionException ree) {
					System.out.println(getName() + " : " + ree);
				}
			}
		}
		finally {
			System.out.println(Thread.currentThread().getName() + " is terminated.");
		}
	}

	public void stopThread() {
		// two-phase termination
		terminated = true;
		interrupt();
	}

}
