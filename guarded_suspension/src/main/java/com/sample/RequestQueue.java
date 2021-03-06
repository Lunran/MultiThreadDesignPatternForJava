package com.sample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

	private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

	public Request getRequest() {
		Request req = null;
		try {
			req = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return req;
	}

	public void putRequest(Request request) {
		try {
			queue.put(request);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
