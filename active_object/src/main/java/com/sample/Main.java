package com.sample;

import com.sample.activeobject.ActiveObject;
import com.sample.activeobject.ActiveObjectFactory;

class Main {

	public static void main(String args[]) {
		ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
		try {
			new MakerClientThread("Alice", activeObject).start();
			new MakerClientThread("Bobby", activeObject).start();
			new DisplayClientThread("Chris", activeObject).start();
			new AddClientThread("Diana", activeObject).start();
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			// do nothing
		}
		finally {
			System.out.println("*** shutdown ***");
			activeObject.shutdown();
		}
	}

}
