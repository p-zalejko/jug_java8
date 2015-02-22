package jug.zg.java8.streams;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo4 {

	private static final int LIMIT = 10_000_000;

	public static void main(final String[] args) {
		// ForkJoinPool commonPool = ForkJoinPool.commonPool();
		// System.out.println(commonPool.getParallelism()); // e.g. 3
		
		final Supplier<Stream<Integer>> supplier = () -> IntStream.range(0, LIMIT).boxed();
		check(supplier.get());
	}

	static void check(final Stream<Integer> stream) {
		final long start = System.currentTimeMillis();
		final long count = stream./* parallel(). */filter(i -> i % 2 == 0).count();
		final long end = System.currentTimeMillis();

		System.out.println("Result: " + count);
		System.out.println((end - start) + " ms");

	}
}
