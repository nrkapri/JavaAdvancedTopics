package java;
import org.junit.Assert;

public class LamdaTest {
	
	public static int result(int x,int y,FirstInterface f)
	{
		return f.firstFunction(x, y);
	}

//	public static void result(int x,int y,SecondInterface f)
//	{
//		f.secondFunction(x, y);
//	}
	
	public static void main(String[] args) {
		int c=9;
		Assert.assertEquals((int)LamdaTest.result(1, 5, (a,b)->
		{
			a=a+c;
			System.out.println(a+b);	
			return a+b;
		}),15);	

		

	}


}
