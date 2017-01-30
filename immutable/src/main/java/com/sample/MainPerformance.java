package com.sample;

class MainPerformance {

	private static final long CALL_COUNT = 100000000L;

	public static void main(String args[]) {
		MainPerformance main = new MainPerformance();
		trial("NotSynch", CALL_COUNT, main.new NotSynch());
		trial("Synch", CALL_COUNT, main.new Synch());
	}

	private static void trial(String msg, long count, Object obj) {
		System.out.println(msg + ": BEGIN");
		long start_time = System.currentTimeMillis();
		for (long i=0; i<count; i++) {
			obj.toString();
		}
		System.out.println(msg + ": END");
		System.out.println("Elapsed time = " + (System.currentTimeMillis() - start_time) + "msec.");
	}

	class NotSynch {

		private final String name = "NotSynch";

		public String toString() {
			return "[ " + name + "]";
		}
	}

	class Synch {

		private final String name = "Synch";

		public synchronized String toString() {
			return "[ " + name + "]";
		}
	}
}
