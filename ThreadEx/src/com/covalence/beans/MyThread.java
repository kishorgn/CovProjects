package com.covalence.beans;

public class MyThread implements Runnable {
	
	Process process ;
	String msg;
	
	public MyThread(Process process, String msg) {
		this.process = process;
		this.msg = msg;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		synchronized (process) {
			process.display(msg);
		}
		
	}

}
