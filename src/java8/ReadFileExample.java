package java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "C:\\Users\\nayank\\Desktop\\README.txt";
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) 
		{
			//stream.forEach(System.out::println);
			//1. filter line 3
			//2. convert all content to upper case
			//3. convert it into a List
			stream
			.filter(line -> !line.contains("Oracle"))
			.map(String::toUpperCase)
			.forEach(x -> System.out.println(x+"\nLINE ENDED====="));
			
			
		} 
		catch (Exception  e) 
		{
			e.printStackTrace();
		}
		
		
		
//		3. BufferedReader + Stream
		List<String> list = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		list.forEach(System.out::println);
		

	}

}
