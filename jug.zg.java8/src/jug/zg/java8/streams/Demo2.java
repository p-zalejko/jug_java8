package jug.zg.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo2 {

    private final String name;
    private final List<Integer> ints;

    public Demo2(final String name, final Integer... i) {
        this.name = name;
        ints = Arrays.asList(i);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getInts() {
        return ints;
    }

    public static void main(final String[] args) {
        final List<Demo2> list = Arrays.asList(new Demo2("foo", 1, 2, 3), new Demo2("bar", 4, 5, 6));

        System.out.println("Example 1: ");
        final Function<Demo2, String> mapper = i -> i.getName();
        list.stream()
        		.map(mapper)
        		.forEach(System.out::print);

        System.out.println("\n\nExample 2: ");
        final Predicate<String> predicate = i -> i.startsWith("f");
        list.stream()
        		.map(mapper)
        		.filter(predicate)
        		.forEach(System.out::print);

        System.out.println("\n\nExample 3: ");
        final Function<Demo2, Stream<Integer>> mapper2 = i -> i.getInts().stream();
        final Optional<Integer> findFirst = list.stream()
                .flatMap(mapper2)
                .filter(i -> i > 5)
                .findFirst();
        findFirst.ifPresent(System.out::print);
    }
}
