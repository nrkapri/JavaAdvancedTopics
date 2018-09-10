package concurrency;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public long count =0;



	public static void main (String []args) throws InterruptedException
	{
		SemaphoreTest st= new SemaphoreTest();
		st.count=0;

		Semaphore smp = new Semaphore(1);

		Thread.sleep(1000);
		Thread t1 = new Thread(new Runnable()
		{

			@Override
			public void run() {

				while(true)
				{
					try {
						smp.acquire();
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println("T1: before increase:"+st.count);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					st.count++;
					System.out.println("T1: after increase:"+st.count);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					smp.release();
				}
			}

		});


		Thread t2 = new Thread(new Runnable()
		{

			@Override
			public void run() {
				while(true)
				{
					try {
						smp.acquire();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("T2: before decrease:"+st.count);
					st.count--;
					System.out.println("T2: after decrease:"+st.count);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					smp.release();
				}
			}

		});


		t1.start();
		t2.start();

	}
}
