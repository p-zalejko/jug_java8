package jug.zg.java8.defaults;

public interface A {

	default /*final */ void print() {
		System.out.println("A.print()");
	}
	
	 
}
