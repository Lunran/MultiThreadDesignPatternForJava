package com.sample;

class Main {

	public static void main(String args[]) {
		Channel channel = new Channel(2);
		channel.startWorkers();
		new ClientThread("Alice", channel).start();
		new ClientThread("Bobby", channel).start();
		new ClientThread("Chris", channel).start();
	}

}
