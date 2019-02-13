package com.scotia.entry.test.question2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTestTwo {

	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		Thread threadOne = new Thread(threadClass);
		threadOne.setName("Thread One");
		Thread threadTwo = new Thread(threadClass);
		threadTwo.setName("Thread Two");
		Thread threadThree = new Thread(threadClass);
		threadThree.setName("Thread Three");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(threadOne);
		executor.submit(threadTwo);
		executor.submit(threadThree);
		executor.shutdown();
		try {
			threadOne.start();
			Thread.sleep(100);
			threadTwo.start();
			Thread.sleep(100);
			threadThree.start();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
