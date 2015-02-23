package jug.zg.java8.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo1 {

    public static void main(final String[] args) {
    	//NOTE: stream can be opened only once!
        final Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(4, 7, 5, 1, 9, 6, 2, 10,3 ,8 );

        System.out.println("Example 1: ");
        final Stream<Integer> stream = streamSupplier.get();
        stream
        	.filter(i -> i > 5)
        	.sorted()
        	.forEach(System.out::print);

        System.out.println("\n\nExample 2: ");
        final Predicate<Integer> predicate = i -> i < 8;
        streamSupplier.get()
        		.filter(i -> i > 5)
        		.filter(predicate)
        		.forEach(System.out::print);

        System.out.println("\n\nExample 3: ");
        final List<Integer> result = streamSupplier.get()
                .filter(i -> i > 5)
                .collect(Collectors.toList());
        result.forEach(System.out::print);
    }
}
