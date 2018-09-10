package concurrency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockInterruptableExample {


	public static void main(String []  args)
	{

		ExecutorService pool  = Executors.newFixedThreadPool(2);

		ReentrantLock lock = new ReentrantLock();

		pool.submit(
				(Runnable) ()->
				{
					int x=100;
					while(x>0) {
						try {
							lock.lockInterruptibly();

							System.out.println("Thread 1:"+x);
							Thread.sleep(1000);
							lock.unlock();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("Thread 1 interupted ");
						}
						finally
						{
							lock.unlock();
						}
							
					}

				}
				);
		
		
		pool.submit(
				(Runnable) ()->
				{
					int x=100;
					while(x>0) {
						try {
							lock.lockInterruptibly();

							System.out.println("Thread 2:"+x);
							Thread.sleep(1000);
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("Thread 2 interupted ");
						}
						finally
						{
							lock.unlock();
						}
					}

				}
				);
		
		
		pool.submit(
				(Runnable) ()->
				{
					int x=100;
					while(x>0) {
						try {
							lock.lock();

							System.out.println("Thread 3:"+x);
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("Thread 3 interupted ");
						}
						finally
						{
							lock.unlock();
						}
					}
					

				}
				);
		
		
		pool.shutdown();
		
		try {
			pool.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
