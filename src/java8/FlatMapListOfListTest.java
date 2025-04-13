package java8;

import java.util.ArrayList;
import java.util.List;



public class FlatMapListOfListTest {
	

class NameData 
{
	String name ;
	int  age;
	public int  getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	List<NameData> child;

	List<NameData> getChild()
	{
		return child;
	}


	public void setChild(NameData child) {
		this.child =  new ArrayList();
		this.child.add(child);
	}
	public NameData(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Node [name=" + name + ", age=" + age + "]";
	}

}

	public static void main(String args[]) {
		
	/*	NameData n1 = new NameData("A",1);
		NameData n2 = new NameData("B",2);
		
		NameData n3 =  new FlatMapListOfListTest.NameData("C",3);
		NameData n4 =  new NameData("D",4);

		n1.setChild(n2);
		n2.setChild(n3);
		n3.setChild(n4);

		NameData n5 = new NameData("E",1);
		NameData n6 = new NameData("F",2);
		NameData n7 =  new NameData("G",3);
		NameData n8 =  new NameData("H",4);

		n5.setChild(n6);
		n6.setChild(n7);
		n7.setChild(n8);

		n4.setChild(n5);

		printIfAge3(n4);*/
	}


	public  static void printIfAge3(NameData n) {
		if(n.getAge()==3)
		{
			System.out.println(n.toString());
		}

		if(n.getChild()!=null)
			n.getChild().stream().forEach(x->printIfAge3(n));

	}



}


