package java8;

import java.util.ArrayList;
import java.util.List;

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