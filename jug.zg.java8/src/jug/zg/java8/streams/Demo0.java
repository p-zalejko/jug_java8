package jug.zg.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo0 {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Stream<Integer> stream = list.stream();
		boolean result = stream.filter(i -> i > 2).anyMatch(i -> true);
		boolean result2 =stream.filter(i -> i > 2).anyMatch(i -> true); // throws an exception
	}
}
