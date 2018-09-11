package collection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class RemoveAllNullFromList {

	public static void main(String[] args) {

		List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
	    List<Integer> listWithoutNulls = list.parallelStream()
	      .filter(Objects::nonNull)
	      .collect(Collectors.toList());
		
	    System.out.println(listWithoutNulls);
	    
	    List<Integer> list1 = Lists.newArrayList(null, 1, 2, null, 3, null);
	    List<Integer> listWithoutNulls1 = list1.stream()
	      .filter(Objects::nonNull)
	      .collect(Collectors.toList());
	    
	    System.out.println(listWithoutNulls1);
	    
	    List<Integer> listWithoutNulls2 = Lists.newArrayList(null, 1, 2, null, 3, null);
	    listWithoutNulls2.removeIf(Objects::isNull);
	    System.out.println(listWithoutNulls2); 
	    
	}

}
