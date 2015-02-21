package jug.zg.java8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import jug.zg.java8.functional.java7.ConsumerImpl;
import jug.zg.java8.functional.java7.FunctionImpl;
import jug.zg.java8.functional.java7.SupplierImpl;

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
     */
    public static void _main(final String[] args) {
        generate(new SupplierImpl(), new FunctionImpl(), new ConsumerImpl());
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

        // Consumer<List<Person>> consumer = Demo::check;
        // Consumer<List<Person>> consumer = items->check(items);
        generate(ageGenerator, nameGenerator, Demo::check);
    }

    private static Integer getRandomAge() {
        return RANDOM.nextInt(50) + 1;
    }

    private static void check(final List<Person> list) {
        list.forEach(System.out::println);// (Consumer<T> action)

        final Predicate<Person> isAdult = (person) -> person.getAge() > 18;
        if (isAdult.test(list.get(0))) {
            System.out.println(list.get(0) + " is adult.");
        }

        final Optional<Person> person = getByName(list, NAMES[0]);
        // like in guava:
        // person.isPresent();
        // Person person2 = person.get();

        person.ifPresent(item -> System.out.println(item)); // (Consumer<T> consumer)
        person.orElseThrow(IllegalStateException::new);// (Supplier<T> exceptionSupplier)
    }

    private static Optional<Person> getByName(final List<Person> list, final String name) {
        for (final Person person : list) {
            if (person.getName().equals(name)) {
                return Optional.of(person);
            }
        }

        return Optional.empty();
    }

}
