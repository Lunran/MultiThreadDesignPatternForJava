package com.sample;

class Main {

	public static void main(String args[]) {
		Data data = new Data("data.txt", "(empty)");
		new ChangerThread("ChangerThread", data).start();
		new SaverThread("ServerThread", data).start();
	}
}
