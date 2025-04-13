package collection;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

//import com.google.common.collect.ImmutableList;

public class CollectorsExample {

	public static void main(String[] args) {
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd","bb");
		
		List<String> result = givenList.stream()
				  .collect(toList());
		System.out.println(result);
		
		List<String> result1 = givenList.stream()
				  .collect(toCollection(LinkedList::new));
		
		System.out.println(result1);
		

		
		//handle duplicates
		Map<String, Integer> result4 = givenList.stream()
				  .collect(toMap(Function.identity(), String::length, (i1, i2) -> i1>i2?i1:i2));
		
		System.out.println(result4);


		Map<String, Integer> result3 = givenList.stream()
				.collect(toMap(Function.identity(), String::length));
		System.out.println(result3);
		//Function.identity() is just a shortcut for defining function that accepts and return the same value;

	//	List<String> result5 = givenList.stream().collect(collectingAndThen(toList(), ImmutableList::copyOf));
		
		System.out.println(givenList.stream()
				  .collect(joining(" ")));
		
		
		
	}

}