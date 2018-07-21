package java;

public class DoubleCheckSingleTon  {

	private  volatile static  DoubleCheckSingleTon INSTANCE;

	private DoubleCheckSingleTon()
	{
		System.out.println("Awesome");
	}

	public static  DoubleCheckSingleTon getInstance()
	{
		if(INSTANCE==null)
		{
			synchronized(DoubleCheckSingleTon.class)
			{
				if(INSTANCE==null)
				{
					INSTANCE = new DoubleCheckSingleTon();
				}
			}
		}
		return INSTANCE;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true)
			 DoubleCheckSingleTon.getInstance();
		
		
	}

}
