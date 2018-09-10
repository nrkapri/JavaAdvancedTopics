package java8;

import java.util.Arrays;
import java.util.List;

public class StreamMapExample {

	public static void main(String[] args) {

		List<String > names = Arrays.asList("Nayan", "Ayaz", "Wassi", "Pratik");
		
		names.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));
	}

}
