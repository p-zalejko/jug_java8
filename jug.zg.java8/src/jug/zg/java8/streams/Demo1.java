package jug.zg.java8.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo1 {

    public static void main(final String[] args) {
    	//NOTE: stream can be opened only once!
        final Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1
        final Stream<Integer> stream = streamSupplier.get();
        stream
        	.filter(i -> i > 5)
        	.forEach(System.out::print);

        // 2
        final Predicate<Integer> predicate = i -> i < 8;
        streamSupplier.get()
        		.filter(i -> i > 5)
        		.filter(predicate)
        		.forEach(System.out::print);

        // 3
        final List<Integer> result = streamSupplier.get()
                .filter(i -> i > 5)
                .collect(Collectors.toList());

        result.forEach(System.out::print);
    }
}
