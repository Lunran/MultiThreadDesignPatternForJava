package com.sample;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import com.sample.activeobject.ActiveObject;

public class AddClientThread extends Thread {

	private final ActiveObject activeObject;
	private String x="1", y="1";

	public AddClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Future<String> future = activeObject.add(x, y);
				Thread.sleep(200);
				String value = future.get();
				System.out.println(Thread.currentThread().getName() + ": value = " + value);
				x = y;
				y = value;
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		} catch (ExecutionException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		} catch (RejectedExecutionException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		} catch (CancellationException e) {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		}
	}

}
