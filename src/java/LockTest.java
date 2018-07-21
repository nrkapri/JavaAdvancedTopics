package java;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public ReentrantLock lock ;
	public List<Integer> ll  ;
	public int maxQueue;

	LockTest(int max )
	{
		ll = new LinkedList<Integer>();
		lock = new ReentrantLock();
		maxQueue= max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LockTest lt = new LockTest(100000);

		Thread prod =  new Thread (()->
		{
			Random r = new Random();

			while(true)
			{
				lt.lock.lock();

				if (lt.ll.size()>=lt.maxQueue)
				{
					System.out.println("full queue");
				}
				else
				{
					lt.ll.add(r.nextInt(1000));
					System.out.println("produce:"+lt.ll.size());
				}
				lt.lock.unlock();
			}

		}
				);



		Thread cons =  new Thread (()->
		{

			while(true)
			{
				lt.lock.lock();

				if(lt.ll.size()==0)
				{
					System.out.println("empty queue");
				}
				else
				{
					lt.ll.remove(0);
					System.out.println("consume:"+lt.ll.size());
				}

				lt.lock.unlock();


			}

		}
				);
		
		
		prod.start();
		cons.start();

	}

}
