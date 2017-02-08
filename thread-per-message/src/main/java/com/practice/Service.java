package com.practice;

public class Service {

	private static Thread worker = null;

	public static synchronized void service() {
		if (worker != null && worker.isAlive()) {
			worker.interrupt();
			try {
				worker.join();
			}
			catch (InterruptedException ie) {
			}
			worker = null;
		}
			System.out.println("service");
			worker = new Thread() {
					public void run() {
						try {
							for (int i=0; i<50; i++) {
								System.out.print(".");
								Thread.sleep(100);
							}
							System.out.println("done.");
						}
						catch (InterruptedException ie) {
							System.out.println("canceled");
						}
					}
				};
			worker.start();
	}

}
