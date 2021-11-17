package com.covelanse.beans;

public interface A {
	void meth1();
	default void meth2() {
		System.out.println("default meth2 of super interface");
	}
	static void meth3() {
		System.out.println("static meth3 of super interface");
	}
}



