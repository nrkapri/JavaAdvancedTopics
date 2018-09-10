package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class Developer {
	String name ;

	Double salary;


	public Developer(String n,Double salary)
	{
		this.name=n;
		this.salary=salary;

	}

	public Double getSalary()
	{
		return salary;
	}
	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return "Name: "+name+", salary:"+salary;
	}
}
public class ComparatorExample {



	public static void main(String[] args) {



		Comparator<Developer>  devcomp = new Comparator<Developer>()
		{

			@Override
			public int compare(Developer o1, Developer o2) {
				// TODO Auto-generated method stub
				return 0;
			}

		};

		Comparator<Developer> devcomplambda= ( d1, d2) ->{
			return d1.getName().compareTo(d2.getName());
		};

		List<Developer> devs = new ArrayList<Developer>();

		devs.add(new Developer("Nayan",1.0));
		devs.add(new Developer("Ayan",2.0));
		devs.add(new Developer("yan",3.0));

		//Collections.sort(devs, devcomplambda);

		devs.sort(devcomplambda);
		devs.forEach((e)->System.out.println(e.toString()));

		devs.sort( (d1,d2)-> 
		{
			return d1.getSalary().compareTo(d2.getSalary());
		});

		System.out.println("");
		devs.forEach((e)->System.out.println(e.toString()));

		devs.stream().sorted(
				new Comparator<Developer >()
				{
					@Override
					public int compare(Developer o1, Developer o2) {
						// TODO Auto-generated method stub
						if  (o1.getSalary() - o2.getSalary()> 0)
							return 1;
						else if (o1.getSalary().equals(o2.getSalary()))
						{
							return 0;
						}
						else return -1;
					}
				}
				).forEach(x -> System.out.println(x));
	}

}
