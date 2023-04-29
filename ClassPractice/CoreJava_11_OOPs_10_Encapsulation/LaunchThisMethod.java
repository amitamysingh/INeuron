package ClassPractice.encapsulation;

class Student2 {
	private String name;
	private int age;
	private String city;
	
	public Student2(String name, int age, String city) {
		this.name=name;
		this.age=age;
		this.city=city;
	}
	public Student2() {
		age=20;
		city="Bengaluru";
	}
	public Student2(String name) {
		this.name=name;
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

public class LaunchThisMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
