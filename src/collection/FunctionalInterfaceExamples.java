package collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfaceExamples {

	public static void main (String [] args)
	{
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		Integer value1 = nameMap.computeIfAbsent("John1", String::length);

		System.out.println(value+","+value1);

		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'" + s + "'";

		Function<Integer, String> quoteIntToString = quote.compose(intToString);

		System.out.println(quoteIntToString.apply(5));

		//BiFunction
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);

		salaries.replaceAll((name, oldValue) -> 
		name.equals("Freddy") ? oldValue : oldValue + 10000);
		System.out.println(salaries);

		//Supliers
		/*
		 * The Supplier functional interface is yet another Function specialization that does not take any
		 *  arguments. It is typically used for lazy generation of values. For instance, let�s define a 
		 *  function that squares a double value. It will receive not a value itself, but a Supplier of this
		 *   value:
		 * */
		
		//Consumer
		/*
		 As opposed to the Supplier, the Consumer accepts a generified argument and returns nothing. It is a
		 function that is representing side effects.
		 * */
		List<String> names = Arrays.asList("John", "Freddy", "Samuel");
		names.forEach(name -> System.out.println("Hello, " + name));
		
		//BiConsumer
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);
		 
		ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
		
		//Predicaes
		 
		List<String> namesWithF = names.stream()
		  .filter(name -> name.startsWith("F"))
		  .collect(Collectors.toList());
		System.out.println(namesWithF);
		
		//Operator
		//Unary
		names.replaceAll(name -> name.toUpperCase());
		System.out.println(names);
		//binary
		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
		 
		int sum = values.stream()
		  .reduce(0, (i1, i2) -> i1 + i2);
		
		System.out.println(sum);
		
		
	}
}
