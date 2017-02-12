package com.sample;

class ReorderMain {

	public static void main(String args[]) {

		final DataRace obj = new DataRace();

		new Thread() {
			public void run() {
				while (true) {
					obj.write();
				}
			}
		}.start();

		new Thread() {
			public void run() {
				for (int i=0; true; i++) {
					obj.read(i);
				}
			}
		}.start();
	}

}

class DataRace {

	private volatile int x=0, y=0;

	public void write() {
		y = 0;
		x = 0;
		x = 100;
		y = 50;
	}

	public void read(int i) {
		if (x < y) {
			System.out.println(i + ": x < y");
		}
	}
}
