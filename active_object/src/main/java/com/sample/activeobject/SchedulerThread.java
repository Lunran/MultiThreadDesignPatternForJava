package com.sample.activeobject;

/**
 * Has a queue for MethodRequest as in Producer-Consumer pattern
 *
 */
public class SchedulerThread extends Thread {

	private final ActivationQueue queue;

	public SchedulerThread(ActivationQueue queue) {
		this.queue = queue;
	}

	public void invoke(MethodRequest<?> request) {
		queue.putRequest(request);
	}

	@Override
	public void run() {
		while (true) {
			MethodRequest<?> request = queue.takeRequest();
			request.execute();
		}
	}

}
