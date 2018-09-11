package collection;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakHashMapExample {

	public static void main(String[] args) {
		//Strong References
		Integer prime = 1;
		
		SoftReference<Integer> soft = new SoftReference<Integer>(prime); 
		prime = null;
		
		/*Simply put, an object that has a SoftReference pointing to it won’t 
		be garbage collected until the JVM absolutely needs memory.
		*/
		// Weak References
		/*
		 * When we made a prime reference null, the prime object will be garbage collected in the
		 *  next GC cycle, as there is no other strong reference pointing to it.
		 * */
		prime=1;
		WeakReference<Integer> weak = new WeakReference<Integer>(prime); 
		prime = null;
		
	}

}
