package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {

	private String name;
	private Set<String> book;

	public void addBook(String book) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}


}

public class FlatMapExample {


	public static void main(String[] args) {

		/**
		 * In Java 8, Stream can hold different data types, for examples:

Stream<String[]>	
Stream<Set<String>>	
Stream<List<String>>	
Stream<List<Object>>
Copy
But, the Stream operations (filter, sum, distinct…) and collectors do not support it, so, we need flatMap() to do the following conversion :

Stream<String[]>		-> flatMap ->	Stream<String>
Stream<Set<String>>	-> flatMap ->	Stream<String>
Stream<List<String>>	-> flatMap ->	Stream<String>
Stream<List<Object>>	-> flatMap ->	Stream<Object>
		 */


		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		//Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);

		//filter a stream of string[], and return a string[]?
		Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));

		stream.forEach(System.out::println);
		//returns  empty 



		//use flatMap() to convert Stream<String[]> to Stream<String>.

		String[][] data1 = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

		//Stream<String[]>
		Stream<String[]> temp1 = Arrays.stream(data1);

		//Stream<String>, GOOD!
		Stream<String> stringStream = temp1.flatMap(x -> Arrays.stream(x));

		Stream<String> stream1 = stringStream.filter(x -> "a".equals(x.toString()));

		stream1.forEach(System.out::println);

		//Stream + Set + flatMap

		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);

		List<String> collect =
				list.stream()
				.map(x -> x.getBook())      //Stream<Set<String>>
				.flatMap(x -> x.stream())   //Stream<String>
				.distinct()
				.collect(Collectors.toList());

		collect.forEach(x -> System.out.println(x));


		//Stream + Primitive + flatMapToInt
		int[] intArray = {1, 2, 3, 4, 5, 6};

		//1. Stream<int[]>
		Stream<int[]> streamArray = Stream.of(intArray);

		//2. Stream<int[]> -> flatMap -> IntStream
		IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

		intStream.forEach(x -> System.out.println(x));
		
		
		
	}

}
