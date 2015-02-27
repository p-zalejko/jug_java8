package jug.zg.java8.annotation;

import java.io.IOException;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

public class ExampleAnnotations {

	// 1.
	List<@ReadOnly String> items;

	// 2.
	ExampleAnnotations(@NonNull String name) {
	}

	// 3.
	void foo() throws @Fatal IOException {
	}

	public static void main(String[] args) {
		// in eclipse in order to launch null validation go to
		// window > preferences > Java > compiler > errors/warnings > null analysis
		new ExampleAnnotations(null);
		new @ReadOnly ExampleAnnotations("foo");

		// 4.
		boolean isEmail = "foo@bar.com" instanceof @Email String;
	}
}
