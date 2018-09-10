package concurrency;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AtomicInteger a = new AtomicInteger(5);
		
		int x= a.incrementAndGet();
		
	}

}
