package collection;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


/**
 * 
Random access takes O(1) time
Adding element takes amortized constant time O(1)
Inserting/Deleting takes O(n) time
Searching takes O(n) time for unsorted array and O(log n) for a sorted one
 */
public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		assertTrue(list.isEmpty());

		List<String> list1 = new ArrayList<>(20);

		System.out.println(list1);

		Collection<Integer> number 
		= IntStream.range(0, 10).boxed().collect(Collectors.toSet());

		List<Integer> list2 = new ArrayList<>(number);
		assertEquals(10, list2.size());
		assertTrue(number.containsAll(list2));
		System.out.println(list2);


		//Adding

		List<Long> list3 = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
		LongStream.range(4, 10).boxed()
		.collect(collectingAndThen(toCollection(ArrayList::new), ys -> list3.addAll(0, ys)));

		System.out.println(list3);


		//iterate 
		List<Integer> list4 = new ArrayList<>(
				IntStream.range(0, 10).boxed().collect(toCollection(ArrayList::new))
				);
		ListIterator<Integer> it = list4.listIterator(list4.size());
		List<Integer> result = new ArrayList<>(list4.size());
		while (it.hasPrevious()) {
			result.add(it.previous());
		}

		Collections.reverse(list4);
		System.out.println(list4);


		//Searching in the List
		List<String> list5 = LongStream.range(0, 16)
				.boxed()
				.map(Long::toHexString)
				.collect(toCollection(ArrayList::new));
		List<String> stringsToSearch = new ArrayList<>(list5);
		stringsToSearch.addAll(list5);

		System.out.println(stringsToSearch);
		Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));

		List<String> result5 = stringsToSearch
				.stream()
				.filter(matchingStrings::contains)
				.collect(toCollection(ArrayList::new));

		assertEquals(6, result5.size());

		System.out.println(result5);
		
		
		//search in sorted list
		List<String> copy = new ArrayList<>(stringsToSearch);
		Collections.sort(copy);
		int index = Collections.binarySearch(copy, "f");
		System.out.println(copy);
		System.out.println(index);
		
		//remove 
		/*
		 * But be careful when working with boxed types such as Integer. 
		 * In order to remove a particular element, you should first box 
		 * int value or otherwise, an element will be removed by its index.
		 * */
		
		Set<String> matchingStrings1
		 = new HashSet<String >(Arrays.asList("a", "b", "c", "d", "e", "f"));
		
		System.out.println(stringsToSearch);
		System.out.println(matchingStrings1);
		
		Iterator<String> itr = stringsToSearch.iterator();
		while (itr.hasNext()) {
		    if (matchingStrings1.contains(itr.next())) {
		        itr.remove();
		    }
		}
		System.out.println(stringsToSearch);
		
		//immutable ArrayList 
		List<String> list9 = new ArrayList<String>(Arrays.asList("one", "two", "three"));
	    List<String> unmodifiableList = Collections.unmodifiableList(list9);
	    unmodifiableList.add("four");
		
	}

}
