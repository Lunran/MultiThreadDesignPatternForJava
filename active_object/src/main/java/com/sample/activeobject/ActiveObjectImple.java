package com.sample.activeobject;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImple implements ActiveObject {

	private final ExecutorService service = Executors.newSingleThreadExecutor();

	@Override
	public Future<String> makeString(final int count, final char fillchar) {
		class MakeStringRequest implements Callable<String> {
			@Override
			public String call() {
				char[] buffer = new char[count];
				for (int i=0; i<count; i++) {
					buffer[i] = fillchar;
					try {
						Thread.sleep(100);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return new String(buffer);
			}
		}
		return service.submit(new MakeStringRequest());
	}

	@Override
	public void displayString(final String string) {
		class DisplayStringRequest implements Runnable {
			@Override
			public void run() {
				try {
					System.out.println("displayString: " + string);
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		service.execute(new DisplayStringRequest());
	}

	@Override
	public Future<String> add(final String x, final String y) {
		class AddRequest implements Callable<String> {
			@Override
			public String call() throws NumberFormatException {
				BigInteger bigX = new BigInteger(x);
				BigInteger bigY = new BigInteger(y);
				return bigX.add(bigY).toString();
			}
		}
		return service.submit(new AddRequest());
	}

	@Override
	public void shutdown() {
		service.shutdown();
	}

}
