package com.covalence.app2;

public class CustomLambda {

	public static void main(String[] args) {
		MyIface wisher = System.out::println;
		wisher.sayHello("Kishor");

	}

}
