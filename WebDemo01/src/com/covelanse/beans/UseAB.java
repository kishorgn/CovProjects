package com.covelanse.beans;;

public class UseAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new ImplAB();
		B b = new ImplAB();
		
		System.out.println("Interface A variable with impl object");
		a.meth1();
		a.meth2();
		A.meth3();
		
		System.out.println();
		
		System.out.println("Interface B variable with impl object");
		b.meth1();
		b.meth2();
		B.meth3();

	}

}
