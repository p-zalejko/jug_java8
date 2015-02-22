package jug.zg.java8.methodrefs;

import java.util.Arrays;
import java.util.List;

public class Demo {

	public static void main(final String[] args) {
		final List<String> list = Arrays.asList("a", "b", "c", "d");

		list.forEach(item -> System.out.print(item));

		list.forEach(System.out::print);

		list.forEach(Demo::print);
	}

	public static void print(final String s) {
		System.out.print(s);
	}

}
