package com.sample;

import com.sample.activeobject.ActiveObject;
import com.sample.activeobject.Result;

/**
 * Creates a thread as in Thread-Per-Message pattern
 *
 */
public class MakerClientThread extends Thread {

	private final ActiveObject activeObject;
	private final char fillchar;

	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillchar = name.charAt(0);
	}

	@Override
	public void run() {
		try {
			for (int i=0; true; i++) {
				Result<String> result = activeObject.makeString(i, fillchar);   // Future pattern
				Thread.sleep(10);
				String value = result.getResultValue();
				System.out.println(Thread.currentThread().getName() + ": value = " + value);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
