package com.sample;

public class ClientThread extends Thread {

	public ClientThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName() + " BEGIN");
		for (int i=0; i<10; i++) {
			Log.println("main: i = " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " END");
	}

}
