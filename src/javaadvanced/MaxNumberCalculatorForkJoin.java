package java;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaxNumberCalculatorForkJoin extends RecursiveTask {

	List<Integer> arr;
	
	final long THRESHOLD = 5;
	
	
	MaxNumberCalculatorForkJoin(List<Integer> arr)
	{
		
		this.arr=arr; 
	}
	

	@Override
	protected Object compute() {
		System.out.println("compute:"+arr.size());
		
		System.out.println("Size: "+ arr.size()+",:" + arr.toString());		
		
		if(arr.size()>THRESHOLD)
		{
			MaxNumberCalculatorForkJoin left = new MaxNumberCalculatorForkJoin(arr.subList(0, arr.size()/2));
			MaxNumberCalculatorForkJoin right = new MaxNumberCalculatorForkJoin(arr.subList(arr.size()/2, arr.size()));
			left.fork();
			//right.fork();
			
			//return Math.max((Integer)left.join(), (Integer)right.join());
			return Math.max((Integer)right.compute(), (Integer)left.join());
		}
		else
		{
			int max = Integer.MIN_VALUE;
			
			for(int i=0;i<arr.size();i++)
			{
				if(arr.get(i)>max)max= arr.get(i);
			}
			return new Integer(max);
		}
		
	}
	
	
	public static void main (String [] args)
	{
		ForkJoinPool fp=  new ForkJoinPool(10);
		
		ArrayList<Integer> target = new ArrayList<Integer>();
		
		Random r = new Random();
		
		int lmax=Integer.MIN_VALUE;
		for(int i=0;i<1000;i++)
		{
			Integer k = r.nextInt(10000);
			target.add(k);

			if (k>lmax)
				lmax=k;
		}
		
		Integer max= (Integer) fp.invoke(new MaxNumberCalculatorForkJoin(target));
		
		System.out.println("Forked max is :" +max);
		System.out.println("lmax is :" +lmax);
	}
}
