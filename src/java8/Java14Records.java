package java8;

/*https://www.youtube.com/watch?v=gJ9DYC-jswo&ab_channel=CodingwithJohn*/

import java.util.Objects;

public class Java14Records {




    public static void main(String[] args) {

        EmployeeClass empClass = new EmployeeClass("Nayan", 33);

        EmployeeRecod empRecord =  new EmployeeRecod("Kapri", 32);

        System.out.println(empClass.getName());
        System.out.println(empRecord.name());

        System.out.println(empClass.toString());
        System.out.println(empRecord);
        System.out.println(empRecord.nameInUpperCase());
        EmployeeRecod.printAnything();
        System.out.println(EmployeeRecod.DEFAULT_NAME);

        EmployeeRecod junior =  new EmployeeRecod("Junior", 23);
        System.out.println(empRecord.compareTo(junior));

        EmployeeRecod kid = new EmployeeRecod("Kid", 12);

    }
}

record EmployeeRecod  (String name , int age ) implements  Comparable{

    public static  final String DEFAULT_NAME= "John";
    //public int defaultAge =10; -- instance variable   not allowed
    //cant extend anyother class .... implicitly extend Record class
    // implicitly final class ...  noone can extend class
    //can implement any interface
    //create canonical constructor automatically
    //allows to override the canonical constructor and allow to do some additional validation

// compact constructor ... the all argument and setters are implicitly added
    EmployeeRecod{
        if (age<18 ) throw new IllegalArgumentException("Age cant be below 18 ")  ;
    }

    public String nameInUpperCase(){
        return name.toUpperCase();
    }

    public static void printAnything()
    {
        System.out.println("Anything");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof EmployeeRecod ){
            EmployeeRecod temp = (EmployeeRecod) o;
            return this.age - temp.age;
        }
        return  1;
    }
}

 class EmployeeClass {
    private final String name ;

     public int getAge() {
         return age;
     }

     private final int age;

     public String getName() {
         return name;
     }

     public EmployeeClass(String name, int age) {
         this.name = name;
         this.age = age;
     }

     @Override
     public boolean equals(Object o) {
         if (o == null || getClass() != o.getClass()) return false;
         EmployeeClass that = (EmployeeClass) o;
         return age == that.age && Objects.equals(name, that.name);
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, age);
     }

     @Override
     public String toString() {
         return "EmployeeClass{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }
 }