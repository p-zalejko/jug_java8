package jug.zg.java8.methodrefs;

import java.util.function.Supplier;

public class Demo3 {

	public static void main(String[] args) {
		Supplier<Double> random1 = Math::random;
		System.out.println(random1.get());

		// constructor reference.
		Supplier<Demo3> instanceFactory = Demo3::new;
		System.out.println(instanceFactory.get());
	}
}
