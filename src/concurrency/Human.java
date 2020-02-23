package concurrency;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Human {
   
 
    public Human() {
        super();
    }
 
    public Human(String name, int age) {
        super();
 
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String name;
    private int age;
 
    // standard getters/setters, equals and hashcode
    public static int compareByNameThenAge(Human lhs, Human rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.age - rhs.age;
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }
    
    public static void main (String[] args)
    {
    	List<Human> hl = new ArrayList<Human>();
    	
    	hl.add(new Human("A",10));
    	hl.add(new Human("B",12));
    	hl.add(new Human("B",11));
    	hl.add(new Human("Z",99));
    	
    	hl.add(new Human("Y",98));
    	
    	hl.sort(new Comparator<Human>()
    			{
					@Override
					public int compare(Human h1, Human h2) {
						// TODO Auto-generated method stub
						return h1.getName().compareTo(h2.getName());
					}
    		
    			});
    	
    	hl.sort(
    			(h1,h2)-> h1.getName().compareTo(h2.getName())
    			);
    	
    	hl.sort(  Human::compareByNameThenAge		);
    	
//    	hl.sort(
//    			(Comparator.comparing(Human::getName)).reversed());
    	
    	System.out.println(hl.toArray().toString());
    	
    }
}