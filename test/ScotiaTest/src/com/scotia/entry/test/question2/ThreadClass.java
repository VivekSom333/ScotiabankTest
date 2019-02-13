package com.scotia.entry.test.question2;

public class ThreadClass implements Runnable {
	 public volatile Integer lock = 1;
	 
	 
	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is Running");
	}

}
