package jug.zg.java8.functional;

import java.text.MessageFormat;

public class Person {
    private final Integer age;
    private final String name;

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}(age {1})", name, age);
    }
}
