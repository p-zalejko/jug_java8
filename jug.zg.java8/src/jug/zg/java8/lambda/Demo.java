package jug.zg.java8.lambda;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class Demo {
    public static void main(final String[] args) throws Exception {
        // 1.
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };

        r.run();

        // using lambda expression:
        final Runnable withLambda = () -> System.out.println("Hello!");
        withLambda.run();

        // 2.
        final List<String> list = Arrays.asList("a", "c", "b");
        // no more code like this:
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(final String o1, final String o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        Collections.sort(list, (final String o1, final String o2) -> o1.compareTo(o2));
        Collections.sort(list, (o1, o2) -> {
            final int result = o1.compareTo(o2);
            return result;// return is needed when {}
            });

        // 3.
        final List<String> items = Arrays.asList("a", "b", "d");
        for (final String item : items) {
            System.out.print(item);
        }

        // Using lambda:
        items.forEach(e -> System.out.println(e));

        // 4
        final Callable<Runnable> callable = new Callable<Runnable>() {

            @Override
            public Runnable call() throws Exception {
                return new Runnable() {

                    @Override
                    public void run() {
                        System.out.println("hi");
                    }
                };
            }
        };

        final Callable<Runnable> callableWithLambda = () -> () -> System.out.println("hi");
        callableWithLambda.call().run();

        // 5.
        final Button button = new Button();
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println(e);
            }
        });

        // using lambda
        button.addActionListener(e -> System.out.println(e));
    }
}