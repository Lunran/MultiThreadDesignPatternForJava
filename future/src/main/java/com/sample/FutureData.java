package com.sample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data {

	public FutureData(Callable<RealData> callable) {
		super(callable);
	}

	@Override
	public String getContent() throws ExecutionException {
		String content = null;
		try {
			content = get().getContent();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		return content;
	}

}
