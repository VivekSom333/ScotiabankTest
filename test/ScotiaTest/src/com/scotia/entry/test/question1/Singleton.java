package com.scotia.entry.test.question1;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
		System.out.println("Singleton constructor called");
	}

	public static Singleton getInstance() {

		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
					System.out.println("Singleton instance created");
				}
			}
		}
		return instance;
	}
}