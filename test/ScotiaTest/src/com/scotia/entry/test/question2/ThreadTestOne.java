package com.scotia.entry.test.question2;

public class ThreadTestOne {

	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		Thread threadOne = new Thread(threadClass);
		threadOne.setName("Thread One");
		Thread threadTwo = new Thread(threadClass);
		threadTwo.setName("Thread Two");
		Thread threadThree = new Thread(threadClass);
		threadThree.setName("Thread Three");

		try {
			threadOne.start();
			threadOne.join();
			threadTwo.start();
			threadTwo.join();
			threadThree.start();
			threadThree.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
