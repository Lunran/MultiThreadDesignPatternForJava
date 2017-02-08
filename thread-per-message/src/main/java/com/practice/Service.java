package com.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

	private static Lock lock = new ReentrantLock();

	public static void service() {
		if (!lock.tryLock()) {
			System.out.println("balks");
			return;
		}
		try {
			System.out.println("service");
			for (int i=0; i<50; i++) {
				System.out.print(".");
				Thread.sleep(100);
			}
			System.out.println("done.");
		}
		catch (InterruptedException ie) {
			System.out.println("canceled");
		}
		finally {
			lock.unlock();
		}
	}

}
