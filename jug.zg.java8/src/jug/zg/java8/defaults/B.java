package jug.zg.java8.defaults;

/**
 * NOTE: default and static methods do not break the functional interface
 * contract.
 */
@FunctionalInterface
public interface B {

	void hi();

	default void print() {
		System.out.println("B.print()");
	}

	static void exampleStaticMethod() {
		System.out.println("B.foo()");
	}
}
