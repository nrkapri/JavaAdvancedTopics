package java;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FutureTask[] futuretasks = new FutureTask[5];
		
		for (int i =0;i<5;i++)
		{
			futuretasks[i] = new FutureTask(new Callable()
					{

						@Override
						public Object call() throws Exception {

							Random  r= new Random();
							Thread.sleep(1000);
							return r.nextInt(100);
							
							
						}
				
					});
			
			new Thread(futuretasks[i]).start();
			
		}
		
		
		int sum=0;
		for(int i=0;i<5;i++)
		{
			System.out.println(futuretasks[i].get());
			
			sum+=(Integer)futuretasks[i].get();
		}
		
		System.out.println(sum);
	}

}
