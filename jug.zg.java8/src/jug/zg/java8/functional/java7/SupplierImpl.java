package jug.zg.java8.functional.java7;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierImpl implements Supplier<Integer> {

    private static final Random RANDOM = new Random();

    @Override
    public Integer get() {
        return RANDOM.nextInt(50) + 1;
    }

}
