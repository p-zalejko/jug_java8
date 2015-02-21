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
		new ExampleAnnotations(null);
		new ExampleAnnotations("foo");
		
		// 4.
		boolean isEmail = "foo@bar" instanceof @Email String;
	}
}
