package jug.zg.java8.annotation.repeatable;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Foos.class)
public @interface Foo {

    String value() default "";
}
