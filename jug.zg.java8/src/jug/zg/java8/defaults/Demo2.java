package jug.zg.java8.defaults;

public class Demo2 implements A, B {

	public void print() {
		System.out.println("Demo.print()");
		A.super.print();
		B.super.print();
	}

	@Override
	public void hi() {
		System.out.println("Demo.hi()");
	}

	public static void main(String[] args) {
		new Demo2().print();
		
		// static method:
		B.exampleStaticMethod();
	}
}
