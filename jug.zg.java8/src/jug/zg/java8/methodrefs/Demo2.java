package jug.zg.java8.methodrefs;

import java.util.Arrays;

public class Demo2 {

    public static void main(final String[] args) {
        final String[] items = { "b", "a", "d", "c" };
        Arrays.sort(items, Demo2::compare);
        Arrays.sort(items, Demo2::compare2);
        Arrays.sort(items, String::compareToIgnoreCase);
        // a.compareToIgnoreCase(b);

        Arrays.sort(items, (a, b) -> a.compareTo(b));
    }

    public static int compare(final String o1, final String o2) {
        return o1.compareTo(o2);
    }

    public static int compare2(final String o1, final String o2) {
        return o2.compareTo(o1);
    }
}
