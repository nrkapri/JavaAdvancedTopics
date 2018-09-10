package concurrency;


import java.io.IOException;

class Parent {
	public void f() throws IOException
	{
		System.out.println("parent ");
	}
}

public class OverridingTest extends Parent  {

	public void f() throws IOException
	{
		System.out.println("parent ");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverridingTest o = new OverridingTest();
		
		
	}

}
