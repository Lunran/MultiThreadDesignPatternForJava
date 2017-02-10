package com.sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {

	private PrintWriter writer = null;

	public TSLog(String filename) {
		try {
			writer = new PrintWriter(new FileWriter(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(String content) {
		writer.println(content);
	}

	public void close() {
		writer.println("==== End of log ====");
		writer.close();
	}

}
