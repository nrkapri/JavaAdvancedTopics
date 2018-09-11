package collection;

import java.util.Arrays;
import java.util.List;

public class ListExceptions {

	public static void main(String[] args) {

		//2. UnsupportedOperationException
		/**
a fixed-size List as of size of a given array
an element of the same type as the one in the original array and it must be an Object
elements in the same order as in original array
a list that is serializable and implements RandomAccess
		 */
		
		List<String> flowers = Arrays.asList("Ageratum", "Allium", "Poppy", "Catmint");
		//flowers.add("Celosia");
		
		
	}

}
