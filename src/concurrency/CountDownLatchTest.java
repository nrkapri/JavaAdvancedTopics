package concurrency;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		CountDownLatch latch = new CountDownLatch(3);
		Thread t1=  new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
				System.out.println("Thread 1");
			}
			
		},
				"Thread 1");
		
		Thread t2=  new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
				System.out.println("Thread 2");
			}
			
		},
				"Thread 2");
		
		
		Thread t3=  new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
				System.out.println("Thread 3");
			}
			
		},
				"Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All latch done");
		
		
	}

}
