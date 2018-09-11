package collection;

import java.util.ArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueExample {

	public static void main (String [] args) throws InterruptedException
	{
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		ArrayList<Integer> polledElements = new ArrayList<>();
		  
		queue.add(1);
		queue.add(5);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		 
		queue.drainTo(polledElements);
		
		System.out.println(queue);
		System.out.println(polledElements);
		
		/*
		 If we were dealing with a standard queue, we would call poll() to retrieve elements. 
		 However, if the queue was empty, a call to poll() would return null.

		 The PriorityBlockingQueue implements the BlockingQueue interface, which gives us some
		 extra methods that allow us to block when removing from an empty queue. Let’s try using
		 the take() method, which should do exactly that:
		 * */
		
		new Thread(() -> {
			  System.out.println("Polling...");
			 
			  try {
			      Integer poll = queue.take();
			      System.out.println("Polled: " + poll);
			  } catch (InterruptedException e) {
			      e.printStackTrace();
			  }
			}).start();
			 
			Thread.sleep(TimeUnit.SECONDS.toMillis(5));
			System.out.println("Adding to queue");
			queue.add(1);

			
			/*
			add() – returns true if insertion was successful, otherwise throws an IllegalStateException
			put() – inserts the specified element into a queue, waiting for a free slot if necessary
			offer() – returns true if insertion was successful, otherwise false
			offer(E e, long timeout, TimeUnit unit) – tries to insert element into a queue and waits for
			 an available slot within a specified timeout
			
			take() – waits for a head element of a queue and removes it. If the queue is empty, it blocks
			 and waits for an element to become available
			poll(long timeout, TimeUnit unit) – retrieves and removes the head of the queue, waiting up to
			 the specified wait time if necessary for an element to become available. Returns null after a timeout
			 **/
			
			
	}
}
