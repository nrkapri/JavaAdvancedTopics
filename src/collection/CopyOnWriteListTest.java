package collection;

/**
 * 
 The design of the CopyOnWriteArrayList uses an interesting technique to make it thread-safe without a need for synchronization. When we are using any of the modify methods – such as add() or remove() – the whole content of the CopyOnWriteArrayList is copied into the new internal copy.

Due to this simple fact, we can iterate over the list in a safe way, even when concurrent modification is happening.

When we’re calling the iterator() method on the CopyOnWriteArrayList, we get back an Iterator backed up by the immutable snapshot of the content of the CopyOnWriteArrayList.

Its content is an exact copy of data that is inside an ArrayList from the time when the Iterator was created. Even if in the meantime some other thread adds or removes an element from the list, that modification is making a fresh copy of the data that will be used in any further data lookup from that list.

The characteristics of this data structure make it particularly useful in cases when we are iterating over it more often than we are modifying it. If adding elements is a common operation in our scenario, then CopyOnWriteArrayList won’t be a good choice – because the additional copies will definitely lead to sub-par performance.
 */

import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWriteListTest {

	public static void main(String[] args) {
		
		//Iterating Over CopyOnWriteArrayList While Insertin
		CopyOnWriteArrayList<Integer> numbers 
		  = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});
		Iterator<Integer> iterator = numbers.iterator();
		numbers.add(10);
		
		List<Integer> result = new LinkedList<>();
		iterator.forEachRemaining(result::add);
		
		System.out.println(result);
		
		Iterator<Integer> iterator2 = numbers.iterator();
		List<Integer> result2 = new LinkedList<>();
		iterator2.forEachRemaining(result2::add);
		
		System.out.println(result2);

		//Removing While Iterating is Not Allowed
		
		Iterator<Integer> iterator3 = numbers.iterator();
	    while (iterator3.hasNext()) {
	        iterator3.remove();
	    }
		
	    //
	}

}
