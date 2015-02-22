package jug.zg.java8.streams.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import jug.zg.java8.functional.Person;

public class Demo {
    private static final int NUMBER = 100;
    private final static String[] NAMES = { "Tomek", "Magda", "Dawid", "Anna", "Michal", "Jurek", "Kamil", "Adam" };
    private static final Random RANDOM = new Random();

    public static void generate(final Supplier<Integer> ageGenerator, final Function<Integer, String> nameGenerator,
            final Consumer<List<Person>> consumer) {

        final List<Person> list = new ArrayList<>();
        for (int i = 0; i < NUMBER; i++) {
            final Integer age = ageGenerator.get();
            final String name = nameGenerator.apply(NAMES.length);
            list.add(new Person(name, age));
        }

        consumer.accept(list);
    }

    /*
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    public static void main(final String[] args) {
        final Supplier<Integer> ageGenerator = Demo::getRandomAge;
        final Function<Integer, String> nameGenerator = (bound) -> NAMES[RANDOM.nextInt(bound)];
        Demo.generate(ageGenerator, nameGenerator, Demo::check);
    }

    private static Integer getRandomAge() {
        return RANDOM.nextInt(50) + 1;
    }

    private static void check(final List<Person> list) {
        list.forEach(System.out::println);// (Consumer<T> action)
        System.out.println("\n\n");

        final Predicate<Person> isAdult = (person) -> person.getAge() > 18;
        final Person personToCheck = list.get(0);
        if (isAdult.test(personToCheck)) {
            System.out.println(personToCheck + ", is adult.");
        } else {
            System.out.println(personToCheck + ", is not adult.");
        }

        // final Optional<Person> person = getByName(list, NAMES[0]);
        // person.ifPresent(item -> System.out.println(item));
        // person.orElseThrow(IllegalStateException::new);

        list.stream()
        		.filter(p -> p.getName().equals(NAMES[0]))
        		.findFirst()
        		.ifPresent(System.out::println);

        final Map<String, List<Person>> byName = list.stream()
                .filter(isAdult)
                .filter(p -> p.getAge() < 50)
                .collect(Collectors.groupingBy(Person::getName));

        System.out.println(byName.keySet());
    }

    // private static Optional<Person> getByName(final List<Person> list, final String name) {
    // for (final Person person : list) {
    // if (person.getName().equals(name)) {
    // return Optional.of(person);
    // }
    // }
    //
    // return Optional.empty();
    // }
}
