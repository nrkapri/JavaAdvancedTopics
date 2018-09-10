package concurrency;
import java.util.ArrayList;
import java.util.Random;

public class StreamTest {

	public static void main (String[] arg)
	{
		ArrayList<Integer> rnumlist = new ArrayList<Integer>();

		Random r= new Random();
		
		for (int i =0;i<Math.abs(r.nextInt(1000));i++)
		{
			rnumlist.add(Math.abs(r.nextInt()));
		}
		
		
		
		System.out.println("\nList is:"+rnumlist.size());
		rnumlist.stream().sorted().forEach((i)->System.out.print(i+" "));
		
		System.out.println("\noddList is:"+rnumlist.size());
		rnumlist.stream().filter((i)->i%2!=0).forEach((i)->System.out.print(i+" "));
		
		
		System.out.println("\nsquareList is:"+rnumlist.size());
		rnumlist.stream().filter((i)->i%2!=0).map((x)->x^2).forEach((i)->System.out.print(i+" "));
		
		System.out.println("\nreduce is:"+rnumlist.size());
		Integer z= rnumlist.stream().filter((i)->i%2!=0).map((x)->x^2).reduce(1,(x,y)->x+y,(p,q)->{ 
		System.out.println("combiner");
			return p+q;
		});
		
		System.out.println("Asw:"+z);
		
		
		System.out.println("\nreduce is:"+rnumlist.size());
		Integer as= rnumlist.parallelStream().filter((i)->i%2!=0).map((x)->x^2).reduce(1,(x,y)->x+y,(p,q)->{ 
		System.out.println("combiner");
			return p+q;
		});
		
		System.out.println("Asw:"+as);
		
	}
}
