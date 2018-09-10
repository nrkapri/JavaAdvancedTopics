package concurrency;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer>  pq  =  new PriorityQueue<Integer>(Collections.reverseOrder());

		pq.add(7);
		pq.add(9);
		pq.add(10);
		pq.add(6);
		pq.add(5);
		pq.add(2);
		pq.add(1);

		while(!pq.isEmpty())
			System.out.println(pq.poll());


		PriorityBlockingQueue<Integer>  pbq  =  new PriorityBlockingQueue<Integer>();

		new Thread (

				()->
				{
					Random r = new Random();
					while(true) 
					{
						System.out.println("produce:"+pq.size());
						pbq.put(r.nextInt(1000));
					}
				}
				).start();


		new Thread (

				()->
				{
					while(true) 
					{
						System.out.println("Consume:"+pq.size());
						try {
							pbq.take();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				).start();

	}

}
