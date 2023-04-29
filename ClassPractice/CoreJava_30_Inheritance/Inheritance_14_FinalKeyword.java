package ClassPractice.CoreJava_30_Inheritance;

//Final keyword can be used with class, method and variable

//Final class
final class Bus{
	
	public void run() {
		System.out.println("Bus is running");
	}
}

//final class can't be inherited
//Following will give error
//class Car extends Bus{
//	
//}

class Vehicle{
	
	//final variable
	final int i=10;
	
	//final method
	public final void run() {
		System.out.println("Vehicle is running");
	}
}

class Car extends Vehicle{
	
	//final method can be inherited, but can't be overridden
	//Following will give error
//	public void run() {
//		System.out.println("Car is running");
//	}
	
	//But the method can be called for a Car object
	
	//Final variable
	final int numberOfWheels=4;
	public void displayNumberOfWheels() {
		//numberOfWheels=2; //value of final variables can't be changed
		System.out.println("Number of wheels in  a car are:: "+numberOfWheels);
	}
}
public class Inheritance_14_FinalKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car=new Car();
		
		//calling final method of parent class for a child object
		car.run();
		
		car.displayNumberOfWheels();

	}

}
