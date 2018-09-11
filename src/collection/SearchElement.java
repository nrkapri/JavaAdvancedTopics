package collection;

import java.util.ArrayList;
import java.util.List;

class Customer {
	 
    private int id;
    private String name;
    
    
    
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
    
}

public class SearchElement {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1, "Jack"));
		customers.add(new Customer(2, "James"));
		customers.add(new Customer(3, "Kelly"));
		
		Customer james = new Customer(2, "James");
		if (customers.contains(james)) 
		{
			System.out.println("Contains james");
		}
		
		System.out.println("Customer index:"+customers.indexOf(james) );
		
		Customer james1 = customers.stream()
				.filter(p->p.equals(james))
				.findAny()
				.orElse(null);
		System.out.println(james1);
		
		
		
	}

}
