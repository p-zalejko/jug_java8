package jug.zg.java8.lambda;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.concurrent.Callable;

public class Demo2 {
	public static void main(String[] args) {
		//1
		Callable<Integer> c1 = /* (Callable<Integer>) */() -> {
			return null;
		};

		check(c1);
		System.out.println("");

		//2
		Callable<Integer> c2 = (Callable<Integer> & Serializable & Cloneable & Remote) () -> {
			return null;
		};

		check(c2);

	}

	private static void check(Object object) {
		System.out.println("Is Serializable: " + (object instanceof Serializable));
		System.out.println("Is Cloneable: " + (object instanceof Cloneable));
		System.out.println("Is Remote: " + (object instanceof Remote));

	}
}
