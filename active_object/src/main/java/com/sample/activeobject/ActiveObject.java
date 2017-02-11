package com.sample.activeobject;

import java.util.concurrent.Future;

public interface ActiveObject {

	Future<String> makeString(int count, char fillchar);
	void displayString(String string);
	Future<String> add(String x, String y);
	void shutdown();

}
