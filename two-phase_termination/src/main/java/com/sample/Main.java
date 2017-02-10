package com.sample;

import java.util.concurrent.TimeUnit;

class Main {

	public static void main(String args[]) {
		System.out.println("main: BEGIN");

		CountupThread t = new CountupThread();
		t.start();

		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(5));
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		System.out.println("main: shutdownRequest");
		t.shutdownRequest();

		System.out.println("main: join");
		try {
			t.join();
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		System.out.println("main: END");
	}

}
