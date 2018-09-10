package concurrency;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	
	public static void main (String [] arg) throws InterruptedException, BrokenBarrierException
	{
		CyclicBarrier cb= new CyclicBarrier(4);
		
		Thread t1 = new Thread (new Runnable()
				{
					@Override
					public void run() {
						try {
							cb.await();
						} catch (InterruptedException | BrokenBarrierException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Thread 1");
					}
				});
		
		Thread t2 = new Thread (new Runnable()
		{
			@Override
			public void run() {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 2");
			}
		});
		
		Thread t3 = new Thread (new Runnable()
		{
			@Override
			public void run() {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread 3");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Final cb await call");
		cb.await();
		
		
	}
}
