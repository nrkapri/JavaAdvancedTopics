package collection;

import java.util.LinkedList;

/**
 * 
 * @author NAYANK
 *
 *
Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index
It is not synchronized
Its Iterator and ListIterator iterators are fail-fast (which means that after the iterator’s creation, if the list is modified, a ConcurrentModificationException will be thrown)
Every element is a node, which keeps a reference to the next and previous ones
It maintains insertion order
 */

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<Object> linkedList = new LinkedList<>();
		
		//add
		linkedList.add(1);
		linkedList.add(1, 3);
		linkedList.addFirst(4);
		linkedList.addLast(5);
		
		System.out.println(linkedList);
		
		//remove
		linkedList.remove(1);
		linkedList.removeLast();
		linkedList.removeFirst();
		
		System.out.println(linkedList);
		
		//queue 
		linkedList.push(99);
		linkedList.push(88);
		System.out.println(linkedList.peek());
		System.out.println(linkedList.pop());
		
		
	}

}
