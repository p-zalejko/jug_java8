package jug.zg.java8.functional.java7;

import java.util.List;
import java.util.function.Consumer;

import jug.zg.java8.functional.Person;

public class ConsumerImpl implements Consumer<List<Person>> {

    @Override
    public void accept(final List<Person> t) {
        System.out.println(t);
    }

}
