package com.scotia.entry.test.question1;

import java.lang.reflect.Constructor;

public class TestSingletonNoSingleton {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = null;
		try {
			Constructor[] constructors = Singleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				obj2 = (Singleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(
				"Below objects have different hashcode proves that two different instances exist and hence singleton pattern is broken");
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());

	}

}
