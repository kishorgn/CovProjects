package com.covalence.app2;

public class ThreadDemo_01 {

	public static void main(String[] args) {
		Runnable evenRunnable = () -> even() ;
		
		Runnable oddRunnable = new Runnable() {
			
			@Override
			public void run() {
				int num = 1;
				for(int c = 0 ; c < 50 ; c++) {
					System.out.println("Odd : "+(num +=2 ));
				}
				
			}
		};
		
		
		Thread even = new Thread(() -> even() );
		even.start();
		
		Thread odd = new Thread(oddRunnable);
		odd.start();

	}
	
	public static void even() {
		int num = 0;
		for(int c = 0 ; c < 50 ; c++) {
			System.out.println("Even : "+(num += 2));
		}
	}

}
