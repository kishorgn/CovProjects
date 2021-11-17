package com.covalence.beans;

public class Process {
	public void display(String msg) {
		System.out.print("[ "+msg);
		try {
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ]");
	}
}
