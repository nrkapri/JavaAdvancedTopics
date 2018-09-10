package java8;

import java.util.Random;

public class RandomNumberexample {

	public static void main(String [] args)
	{
		//java.util.Random
		
		System.out.println("java.util.Random:");
		//Random().nextInt(int bound) = Random integer from 0 (inclusive) to bound (exclusive)
		//1. nextInt(range) = nextInt(max - min)
		System.out.println(new Random().nextInt(5));
		
		//2. To include the last value (max value) = (range + 1)
		System.out.println(new Random().nextInt(5 + 1)  );// [0...5] [min = 0, max = 5]
		
		//3. To define a start value (min value) in a range,
		System.out.println(new Random().nextInt(5 + 1)  + 10 );// [0...5]  + 10 = [10...15]
		
		//4. Test [10...30]
		System.out.println(new Random().nextInt((99 - 15) + 1) + 15);
		
		
		
		//Math.random
		
		System.out.println("Math.random");
		int max= 100, min =10;
		System.out.println((int)(Math.random() * ((max - min) + 1)) + min);
		
		
		//3. Java 8 Random.ints
		
		
		System.out.println(" Java 8 Random.ints");
		Random r = new Random();
		System.out.println( r.ints(min, (max + 1)).findFirst().getAsInt());

		//Java 8 only
		System.out.println("Java 8 Random.ints stream");
		new Random().ints(10, 99, 555).forEach(System.out::println);
	}
}
