package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListPartition {

	public static void main(String[] args) {
	
		//Collectors partitioningBy

		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		Map<Boolean, List<Integer>> groups = 
				intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
		List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());

		List<Integer> lastPartition = subSets.get(1);
		List<Integer> expectedLastPartition = List.of(7, 8);
		
		System.out.println(lastPartition+":"+expectedLastPartition);
		System.out.println(subSets);
		
		
		//Collectors groupingBy
		 List<Integer> intList1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		 
		    Map<Integer, List<Integer>> groups1 = 
		      intList1.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));
		    List<List<Integer>> subSets1 = new ArrayList<List<Integer>>(groups1.values());
		 
		    List<Integer> lastPartition1 = subSets1.get(2);
		    List<Integer> expectedLastPartition1 = List.of(7, 8);

			System.out.println(lastPartition1+":"+expectedLastPartition1);
			System.out.println(subSets1);
			
			
		
			
		    
	}

}
