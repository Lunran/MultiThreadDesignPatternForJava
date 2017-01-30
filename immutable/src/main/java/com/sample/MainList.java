package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("unused")
class MainList {
	public static void main(String args[]) {
		// requires "synchronized" for both write and read
		List<Integer> list = new ArrayList<Integer>();

		// requires "synchronized" for read
		//List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

		// requires no "synchronized"
		//List<Integer> list = new CopyOnWriteArrayList<Integer>();

		MainList main = new MainList();
		main.new WriterThread(list).start();
		main.new ReaderThread(list).start();
	}

	class WriterThread extends Thread {

		private final List<Integer> list;

		public WriterThread(List<Integer> list) {
			super("WriterThread");
			this.list = list;
		}

		public void run() {
			for (int i=0; true; i++) {
				synchronized (list) {
					list.add(new Integer(i));
					list.remove(0);
				}
			}
		}
	}

	class ReaderThread extends Thread {

		private final List<Integer> list;

		public ReaderThread(List<Integer> list) {
			super("ReaderThread");
			this.list = list;
		}

		public void run() {
			while (true) {
				synchronized (list) {
					for (Integer n: list) {
						System.out.println(n);
					}
				}
			}
		}
	}
}
