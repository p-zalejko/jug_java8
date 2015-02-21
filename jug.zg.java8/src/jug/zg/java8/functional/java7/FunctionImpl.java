package jug.zg.java8.functional.java7;

import java.util.Random;
import java.util.function.Function;

public class FunctionImpl implements Function<Integer, String> {
    private final static String[] NAMES = { "Tomek", "Magda", "Dawid", "Michal", "Jurek", "Aleksandra", "Adam" };
    private static final Random RANDOM = new Random();

    @Override
    public String apply(final Integer bound) {
        return NAMES[RANDOM.nextInt(bound)];
    }

}
