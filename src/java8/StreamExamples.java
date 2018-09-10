package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public String toString()
	{
		return name+", "+age;
	}

}
public class StreamExamples {




	public static void main (String [] args)
	{
		List<String> input = Arrays.asList("Nayan", "Chayan", "Ayan", "Sayan");

		List<String> result = input.stream()
				.filter((name ) -> name.contains("ayan"))
				.collect(Collectors.toList());

		result.forEach((x)->System.out.println(x+ ", "));


		List<Person> persons = Arrays.asList( 
				new Person("mkyong", 30),
				new Person("Song", 20), 
				new Person("Jong", 40),
				new Person("Young", 40),
				new Person("monk", 40),
				new Person("Sunk", 40)
				);

		persons.stream()
		.filter((p)->  {return p.getAge()>25;})
		.forEach( (p)->System.out.println(p.toString())); 


		Person onk = persons.stream()
				.filter(x -> x.getName().contains("onk"))
				.findAny()
				.orElse(null);
		System.out.println("Onk 1:"+onk.toString());

		long count = persons.stream()
				.filter(x -> x.getAge()>30)
				.map(x -> x.getName().toUpperCase())
				.count();

		System.out.println("Countis :"+count);

		persons.stream()
		.filter(x -> x.getAge()>30)
		.map(x -> x.getName().toUpperCase())
		.forEach(x->System.out.println(x));


		//Convert a Stream to List
		Stream<String> language = Stream.of("java", "python", "node");

		//Convert a Stream to List
		List<String> result1 = language.collect(Collectors.toList());

		result1.forEach(System.out::println);


		//Example – Stream is closed!
		String[] array = {"a", "b", "c", "d", "e"};
		Stream<String> stream = Arrays.stream(array);

		// loop a stream
		stream.forEach(x -> System.out.println(x));

		// reuse it to filter again! throws IllegalStateException
		//long count1 = stream.filter(x -> "b".equals(x)).count();
		//System.out.println(count1);

		//Stream reuse 

		Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

		//get new stream
		streamSupplier.get().forEach(x -> System.out.println(x));

		//get another new stream
		long count1 = streamSupplier.get().filter(x -> "b".equals(x)).count();
		System.out.println(count1);


		
		
		//Check if Array contains a certain value?
		 String[] alphabet = new String[]{"A", "B", "C"};
		 boolean resultx = Arrays.stream(alphabet).anyMatch("A"::equals);
			if (resultx) {
				System.out.println("Hello A");
			}


			 int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		        //Java 8
		        boolean resulty = IntStream.of(number).anyMatch(x -> x == 4);

		        if (resulty) {
		            System.out.println("Hello 4");
		        } else {
		            System.out.println("Where is number 4?");
		        }
			

	}

}
