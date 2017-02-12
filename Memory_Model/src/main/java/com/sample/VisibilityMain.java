package com.sample;

/**
 * This example doesn't show inconsistent result.
 *
 */
class VisibilityMain {

	public static void main(String args[]) {

		NonVisible obj;

		for (int i=0; true; i++) {
			obj = new NonVisible(i);
			obj.start();
			obj.shutdown();

			// you cannot suspend the thread without this sleep
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class NonVisible extends Thread {

	private boolean quit = false;
	private int i;

	public NonVisible(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		while (!quit) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Running: " + i);
		}
	}

	public void shutdown() {
		quit = true;
	}
}
