package ClassPractice.encapsulation;

class Student{
	//If a class has only private members it is called as bean
	//Private variables can't be accessed by/from within any other class directly
	//Data-hiding/binding
	private String name;
	private int age;
	private String city;
	
	//Constructor have same name as Class
	//Can have everything that a method can have, except for return type
	//Constructor does not have return type
	//Need not to have setters
	//Called with object creation itself/instantiation
	//If programmer does not define any constructor, JVM will include default constructor
	//If programmer introduces any constructor, JVM will not include the default constructor
	public Student(String name, int age, String city) {
		this.name=name;
		this.age=age;
		this.city=city;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getCity() {
		return city;
	}
}

public class LaunchStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student std1=new Student("Rohit", 28, "Bengaluru");
		
		System.out.println(std1.getName());
		System.out.println(std1.getAge());
		System.out.println(std1.getCity());
		
		//Demo of:
		//If programmer does not define any constructor, JVM will include default constructor
		//If programmer introduces any constructor, JVM will not include the default constructor
		//Ex: Following will produce error, as no constructor defined by programmer with zero parameter, 
		// but a parameterized one is defined
		/*
		Student std2=new Student();
		*/
	}

}
