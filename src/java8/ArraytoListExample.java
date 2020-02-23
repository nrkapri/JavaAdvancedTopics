package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraytoListExample {

	public static void main(String[] args) {

		int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		List<Integer> list = new ArrayList<>();
		for (int i : number) {
	    	list.add(i);
		}
		
		
		List<Integer> list1 = 
				Arrays
				.stream(number)
				.boxed()
				.collect(Collectors.toList());
	
		System.out.println(list1);
		
		
	}

}
