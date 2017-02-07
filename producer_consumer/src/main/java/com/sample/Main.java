package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Main {

	public static void main(String args[]) {
		Table table = new Table(3);
		List<Thread> threads = new ArrayList<Thread>();
		Collections.addAll(threads,
							new MakerThread("MakerThread-1", table, 123),
							new MakerThread("MakerThread-2", table, 456),
							new MakerThread("MakerThread-3", table, 789),
							new EaterThread("EaterThread-1", table, 012),
							new EaterThread("EaterThread-2", table, 345),
							new EaterThread("EaterThread-3", table, 678));

		for (Thread thread: threads) {
			thread.start();
		}

		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(10));
		} catch (InterruptedException e) {
		}

		for (Thread thread: threads) {
			thread.interrupt();
		}
	}
}
