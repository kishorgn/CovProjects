package com.covalence.app;

import com.covalence.beans.MyThread;
import com.covalence.beans.Process;

public class ProcessThreadApp {

	public static void main(String[] args) {
		Process p = new Process();
		new MyThread(p, "Hello");
		new MyThread(p, "Welcome");
		new MyThread(p, "to");
		new MyThread(p, "Java");
		new MyThread(p, "Threads");
		new MyThread(p, "by");
		new MyThread(p, "Kishor");

	}

}
