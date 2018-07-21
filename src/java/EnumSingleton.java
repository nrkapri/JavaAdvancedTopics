package java;

public enum EnumSingleton {

	INSTANCE ;
	
	private long connection;
	
	EnumSingleton()
	{
		connection= 1234;
	}
	
	public long getConnection()
	{
		return connection;
	}
	
}


