package jug.zg.java8.defaults;

interface C extends A {
	
	default void print() {
		System.out.println("C.print()");
	}
}