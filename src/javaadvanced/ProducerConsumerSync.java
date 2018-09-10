package java;
import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerSync {

	LinkedList<Integer> queue ;

	int maxQsize;

	ProducerConsumerSync(int size )
	{
		this.maxQsize= size;
		queue = new LinkedList<Integer>();
	}


	public LinkedList<Integer> getQueue() {
		return queue;
	}


	public int getMaxQsize() {
		return maxQsize;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProducerConsumerSync pc= new ProducerConsumerSync(4);

		Thread producer = new Thread (new Runnable()
		{

			@Override
			public void run() {

				Random r= new Random();
				long  produced =0;
				
				while(true)
				{

					synchronized(pc.getQueue())
					{
						while (pc.getQueue().size() >=pc.getMaxQsize())
						{
							try {
								pc.getQueue().wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}


						System.out.print("Produce:");
						Integer prod= r.nextInt(1000);
						pc.getQueue().add(prod);
						produced++;
						System.out.println(produced);
						pc.getQueue().notify();


						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}

		});



		Thread consumer = new Thread (new Runnable()
		{
			@Override
			public void run() {

				long consumed=0;
				
				while(true)
				{
					synchronized(pc.getQueue())
					{
						while(pc.getQueue().size()<=0)
						{
							try {
								pc.getQueue().wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						
							System.out.print("Consumed:");
							Integer cons= pc.getQueue().pop();
							consumed++;
							System.out.println(consumed);
							pc.getQueue().notify();
						
					}
				}

			}

		});


		producer.start();
		consumer.start();

	}

}
