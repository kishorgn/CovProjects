package com.covalence.app3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2, 3, 4, 5, 6, 7, 8, 9, 10);
		Consumer consumer = System.out::println;
		Predicate<Integer> evenTester = (a) -> a%2 == 0;
			
		for(int e : list) {
			if(evenTester.test(e)) {
				consumer.accept(e);
			}
			
		}
		
		list.forEach(System.out::print);

	}

}
