package java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExample {

	public static void main(String[] args) {
		
		//Filter a null value from a Stream
		Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

		 List<String> result = language.filter(x -> x!=null).collect(Collectors.toList());

	        result.forEach(System.out::println);
		
	        
	        
	}

}
