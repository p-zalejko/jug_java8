package jug.zg.java8.methodrefs;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(final String[] args) {
        final List<String> list = Arrays.asList("a", "b", "c", "d");

        list.forEach(item -> System.out.print(item));
        System.out.println("");

        list.forEach(System.out::print);
        System.out.println("");

        list.forEach(Demo::print);
    }

    public static void print(final String s) {
        System.out.print(s);
    }

}
