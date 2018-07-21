package java;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTest1 extends RecursiveAction {



	String work ="";
	final int THRESHOLD=5;

	ForkJoinTest1 (String s)
	{
		work=s;
	}


	public void compute()
	{

		if(work.length()>THRESHOLD)
		{
			//divide
			ForkJoinTask partOne  = new ForkJoinTest1(work.substring(0,work.length()/2));
			ForkJoinTask partTwo  = new ForkJoinTest1(work.substring(work.length()/2,work.length()));

			partOne.fork();
			partTwo.fork();
		}
		else
		{
			System.out.println(work.toUpperCase());
		}
	}

		public static void main (String [] args)
		{
			ForkJoinPool pool = new ForkJoinPool (8);
			String s = "I have also attached trouble shooting guide for data setup for 9025 API. Please contact Prajakta for data setup issues.";
			ForkJoinTest1   task=  new ForkJoinTest1(s);
			pool.invoke(task);
		}

	
}