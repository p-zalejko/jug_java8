package jug.zg.java8.lambda.anonymousClass;

import java.util.Comparator;

// javap -c -v Example1

public class Example1 {
    Comparator<Object> comparator = (o1, o2) -> 0;
}
