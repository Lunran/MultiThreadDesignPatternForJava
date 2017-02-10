package com.sample;

import java.util.concurrent.TimeUnit;

class ShutdownHookMain {

	public static void main(String args[]) {
		System.out.println("main: BEGIN");

		Thread.UncaughtExceptionHandler ueh = new Thread.UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread thread, Throwable exception) {
					System.out.println("****");
					System.out.println("UncaughtExceptionHandler: BEGIN");
					System.out.println("currentThread = " + Thread.currentThread());
					System.out.println("thread = " + thread);
					System.out.println("exception = " + exception);
					System.out.println("UncaughtExceptionHandler: END");
				}
			};
		Thread.setDefaultUncaughtExceptionHandler(ueh);

		Thread th = new Thread() {
				@Override
				public void run() {
					System.out.println("****");
					System.out.println("shutdown hook: BEGIN");
					System.out.println("currentThread = " + Thread.currentThread());
					System.out.println("shutdown hook: END");
				}
			};
		Runtime.getRuntime().addShutdownHook(th);

		new Thread("MyThread") {
			@Override
			public void run() {
				System.out.println("MyThread: BEGIN");

				System.out.println("MyThread: SLEEP..");
				try {
					Thread.sleep(TimeUnit.SECONDS.toMillis(3));
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}

				System.out.println("MyThread: DIVIDE");
				int x = 1 / 0;

				System.out.println("MyThread: x = " + x);
				System.out.println("MyThread: END");
			}
		}.start();

		System.out.println("main: END");

	}

}
