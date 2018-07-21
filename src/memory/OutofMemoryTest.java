package memory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutofMemoryTest {

	public List<Integer> list;
	
	public OutofMemoryTest()
	{
		list= new ArrayList<Integer>();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		OutofMemoryTest ot = new OutofMemoryTest();
	
		Random r = new Random();
		while(true)
		{
			ot.list.add(r.nextInt());
		}
	}

}
