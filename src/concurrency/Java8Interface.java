package concurrency;

public interface Java8Interface {
	
	default void f()
	{
		System.out.print("def");
	}
	
	default void g()
	{
		System.out.print("def");
	}
		
	
	static void f1()
	{
		System.out.print("Static");
	}
	
	static void f2()
	{
		System.out.print("Static");
	}
}

