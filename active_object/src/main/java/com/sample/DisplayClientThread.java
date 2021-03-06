package com.sample;

import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;

import com.sample.activeobject.ActiveObject;

/**
 * Creates a thread as in Thread-Per-Message pattern
 *
 */
public class DisplayClientThread extends Thread {

	private final ActiveObject activeObject;

	public DisplayClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}

	@Override
	public void run() {
		try {
			for (int i=0; true; i++) {
				String string = Thread.currentThread().getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		} catch (RejectedExecutionException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		} catch (CancellationException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		}
	}

}
