package java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerExamples {

	public static void main(String []  args)
	{
		
		
		//1. StringJoiner
		StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bb
        System.out.println(result);
        
        StringJoiner sj1 = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        String result1 = sj1.toString(); //prefix-2016/02/26-suffix
        System.out.println(result1);
        
        //2. String.join
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
     	//java, python, nodejs, ruby
    	String result2 = String.join(", ", list);
    	System.out.println(result2);
    	
    	//3. Collectors.joining
    	List<String> list1 = Arrays.asList("java", "python", "nodejs", "ruby");

    	//java | python | nodejs | ruby
    	String result3 = list1.stream().map(x -> x).collect(Collectors.joining(" | "));
    	
    	System.out.println(result3);
    	
    	
    	
    	
    	
	}
}
