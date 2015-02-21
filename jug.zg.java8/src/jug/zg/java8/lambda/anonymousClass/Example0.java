package jug.zg.java8.lambda.anonymousClass;

import java.util.Comparator;

// javap -c -v Example0

public class Example0 {
    Comparator<Object> comparator = new Comparator<Object>() {
        @Override
        public int compare(final Object o1, final Object o2) {
            return 0;
        }
    };
}
