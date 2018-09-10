package concurrency;
import java.util.concurrent.Phaser;

public class PhaserTest implements Runnable{
	String message ="";
	Phaser ph;
	
	PhaserTest(String msg, Phaser p)
	{
		message=msg;
		ph=p;
		p.register();
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		ph.arriveAndAwaitAdvance();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(message);
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Phaser ph = new Phaser(1);
		
		PhaserTest t1 = new PhaserTest("First", ph);
		PhaserTest t2 = new PhaserTest("second", ph);
		PhaserTest t3 = new PhaserTest("Third", ph);
		PhaserTest t4 = new PhaserTest("Fourth", ph);
		
		new Thread (t1).start();
		new Thread (t2).start();
		new Thread(t3).start();
		new Thread(t4).start();
		
		ph.arriveAndDeregister();
		
		Thread.sleep(100000);
		
		System.out.println("main");
	}

}
