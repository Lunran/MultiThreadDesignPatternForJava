package com.sample;

class Main {
	public static void main(String args[]) {
		RequestQueue requestQueue = new RequestQueue();
		new ClientThread(requestQueue, "Alice", 31313131L).start();
		new ServerThread(requestQueue, "Bobby", 65656565L).start();
	}
}
