package concurrency;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadpoolTest implements Runnable  {

	String name ;

	ThreadpoolTest(String s)
	{
		name=s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=10;

		while(i>0)
		{
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
			i--;
		}
	}

	public static void main (String [] args) throws InterruptedException
	{
		Runnable r1 =new ThreadpoolTest("test 1");
		Runnable r2 =new ThreadpoolTest("test 2");
		Runnable r3 =new ThreadpoolTest("test 3");
		Runnable r4 =new ThreadpoolTest("test 4");
		Runnable r5 =new ThreadpoolTest("test 5");
		Runnable r6 =new ThreadpoolTest("test 6");

		ExecutorService pool = Executors.newFixedThreadPool(3);

		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r6);

		pool.shutdown();

		pool.awaitTermination(10000,TimeUnit.SECONDS);
	//	while(!pool.isTerminated()) {}
	}

}
