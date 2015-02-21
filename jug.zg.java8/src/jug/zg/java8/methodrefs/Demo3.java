package jug.zg.java8.methodrefs;

import java.util.function.Supplier;

public class Demo3 {

	public static void main(String[] args) {
		Supplier<Double> random1 = Math::random;
		
		System.out.println(random1.get());
		System.out.println(random1.get());
	}
}
