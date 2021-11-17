package com.covalence.app;

public class InnerClassThreadEx_01 {
	
	public static void main(String[] args) {
		Thread evenThread = new Thread(new EvenNumbers() );
		Thread oddThread = new Thread(new OddNumbers());
		evenThread.start();
		
		oddThread.start();
	}
	
	public static class EvenNumbers implements Runnable{
		@Override
		public void run() {
			int num = 0;
			for(int c = 0 ; c < 50 ; c++) {
				System.out.println("Even : "+num);
				num += 2;
			}
			System.out.println("End of even thread");
		}
	}
	
	public static class OddNumbers implements Runnable{

		@Override
		public void run() {
			int num = 1;
			for(int c = 0 ; c < 50 ; c++) {
				System.out.println("Odd : "+num);
				num += 2;
			}
			System.out.println("End of odd thread");
		}
		
	}

}
