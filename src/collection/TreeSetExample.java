package collection;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
Simply put, the TreeSet is a sorted collection that extends the AbstractSet class and implements the NavigableSet interface.
Here’s a quick summary of the most important aspects of this implementation:
It stores unique elements
It doesn’t preserve the insertion order of the elements
It sorts the elements in ascending order
It’s not thread-safe
Although TreeSet isn’t thread-safe, it can be synchronized externally using the Collections.synchronizedSet() wrapper:
 */
public class TreeSetExample {

	public static void main(String[] args) {
		Set<String> treeSet = new TreeSet<>();
		
		treeSet.add("Awesome");
		
		System.out.println(treeSet.contains("Awesome"));
		treeSet.remove("Awesome");
		treeSet.add("Good");
		System.out.println(treeSet);
		treeSet.clear();
		System.out.println(treeSet);
		System.out.println(treeSet.size()+","+treeSet.isEmpty());
		
		//Iterate
		treeSet.add("First");
	    treeSet.add("Second");
	    treeSet.add("Third");
	    Iterator<String> itr = treeSet.iterator();
	    while (itr.hasNext()) {
	        System.out.println(itr.next());
	    }
	    
	    Iterator<String> ditr = ((TreeSet<String>) treeSet).descendingIterator();
	    while (ditr.hasNext()) {
	        System.out.println(ditr.next());
	    }
	    
	    /*
	     * The Iterator throws a ConcurrentModificationException if the set is modified at any time after the iterator is created in any way except through the iterator’s remove() method.
	     * */
	    Iterator<String> itr1 = treeSet.iterator();
	    while (itr1.hasNext()) {
	        itr1.next();
	       // treeSet.remove("Second");
	        itr1.remove();
	    }
	    
	    treeSet.add("Fourth");
	    treeSet.add("Fifth");
	    treeSet.add("Sixth");
	    treeSet.add("Seventh");
	    
	    System.out.println("first:"+((TreeSet<String>) treeSet).first());
	    System.out.println("Last:"+((TreeSet<String>) treeSet).last());
	    
	    SortedSet<Integer> treeSetn = new TreeSet<>();
	    treeSetn.add(1);
	    treeSetn.add(2);
	    treeSetn.add(3);
	    treeSetn.add(4);
	    treeSetn.add(5);
	    treeSetn.add(6);
	    
	    System.out.println(treeSetn.subSet(2, 6));
	    
	    System.out.println(treeSetn.subSet(1, 6));
	    
	    System.out.println(treeSetn.tailSet(3));
	    
	    
	    /**
	     * Before Java 7, it was possible to add null elements to an empty TreeSet.

However, that was considered a bug. Therefore, TreeSet no longer supports the addition of null.
Elements inserted into the TreeSet must either implement the Comparable interface or at least be accepted by the specified comparator. All such elements must be mutually comparable,
 i.e. e1.compareTo(e2) or comparator.compare(e1, e2) mustn’t throw a ClassCastException.
	     */
	    
	    treeSet.add(null);
	}

}
