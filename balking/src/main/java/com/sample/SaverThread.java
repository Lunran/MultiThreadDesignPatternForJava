package com.sample;

import java.io.IOException;

public class SaverThread  extends Thread {

	private final Data data;

	public SaverThread(String name, Data data) {
		super(name);
		this.data = data;
	}

	public void run() {
		try {
			while (true) {
				data.save();
				Thread.sleep(1000);
			}
		}
		catch (IOException ie) {
			ie.printStackTrace();
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
