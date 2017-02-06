package com.sample;

class Main {

	public static void main(String args[]) {
		Table table = new Table(3);
		new MakerThread("MakerThread-1", table, 123).start();
		new MakerThread("MakerThread-2", table, 456).start();
		new MakerThread("MakerThread-3", table, 789).start();
		new EaterThread("EaterThread-1", table, 012).start();
		new EaterThread("EaterThread-2", table, 345).start();
		new EaterThread("EaterThread-3", table, 678).start();
	}
}
