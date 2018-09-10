package concurrency;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	
	BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(5);
	
	

	public static void main(String[] args) {

		BlockingQueueTest bqt= new BlockingQueueTest();
		
		new Thread(()->
		 {
			 Random r =new Random();
			while(true)
			{
				System.out.println("produce:"+bqt.bq.size());
				try {
					bqt.bq.put(r.nextInt(1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 ).start();
		
		
		new Thread(()->
		 {
			 
			while(true)
			{
				System.out.println("consume:"+bqt.bq.size());
				try {
					bqt.bq.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 ).start();
	}

}
