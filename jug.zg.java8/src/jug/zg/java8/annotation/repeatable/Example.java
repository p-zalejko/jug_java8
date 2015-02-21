package jug.zg.java8.annotation.repeatable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Example {

    @Foo("a")
    @Foo("b")
    public void doSomething() {

    }

    public static void main(final String[] args) throws Exception {
        final Method method = Example.class.getDeclaredMethod("doSomething");

        final Annotation[] allAnnotations = method.getAnnotations();
        final Foos foosAnnoataion = method.getAnnotation(Foos.class);
        final Foo[] fooAnnoataions = method.getAnnotationsByType(Foo.class);

        System.out.println(allAnnotations.length);
        for (final Foo foo : foosAnnoataion.value()) {
            System.out.println(foo.value());
        }
        System.out.println(fooAnnoataions.length);
    }
}
