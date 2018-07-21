package java;
public class ThreadTest {

	public static void main (String[] arg)
	{
		Thread t1 = new Thread (()->
		{
			int x=1000;
			while(x>0)
			{
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Cancelling");
					return;
				}
				/*try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				System.out.println("thread 1:"+x);
				x--;
			}
		}
		);
		//t1.stop();
		Thread t2 = new Thread (()->
		{
			try {
				t1.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			int x=10;
			while(x>0)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread 2:"+x);
				x--;
			}
		}
		);

		t1.start();
		t2.start();
		t1.interrupt();
		
	}
}
