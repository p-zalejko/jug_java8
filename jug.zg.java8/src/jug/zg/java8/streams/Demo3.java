package jug.zg.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo3 {

    public static void main(final String[] args) {
        final List<Person> list = new ArrayList<>();
        for (int i = 20; i < 45; i++) {
            list.add(new Person("person_" + i, i));
        }

        list.add(new Person("A", 30));
        list.add(new Person("B", 30));
        list.add(new Person("C", 30));

        // 1
        final Map<Integer, List<Person>> result = list.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(result.get(30));

        // 2
        final List<String> collect = list.stream()
                .filter(p -> p.getAge() > 25)
                .filter(p -> p.getAge() < 30)
                .map(Person::getName) // will be called only on matching objects!
                .collect(Collectors.toList());
    }

    static class Person {
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
            return name + " " + age;
        }
    }
}
