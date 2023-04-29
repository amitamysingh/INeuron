package ClassPractice.CoreJava_50_Abstraction;

//1. We can't have an abstract class as final, as final class can be inherited, but its method can't
//be overridden
//2. Abstract class can have a constructor, as any class have a constructor which by default calls to
//parent class constructor using super(), so if a class extends to an abstract class and we create an 
//object of the child class, it will by default make a call to the parent abstract class constructor
//3. Constructor will always have a body in the form of super()

//abstract class with all method implemented, can we create object of such class?
//Mini project - shapes and its area calculation using concept of inheritance, polymorphism and abstraction

//When we have at-least one abstract method, it is important to use abstract keyword for the class
abstract class Abstraction_11_AbstractClass{
	
	//When method implementation is not given, it is called abstract method
	//It is important to use abstract keyword for such methods
	abstract public void firstAbstractMethod();
	abstract public void secondAbstractMethod();
	abstract public void thirdAbstractMethod();
	
	public void firstNonAbstractMethod() {
		System.out.println("This is non-abstract method");
	}
}

class Abstraction_11_ImplementationClass extends Abstraction_11_AbstractClass{
	//If some class extends to an abstract class, it is important for such class to implement all the 
	//abstract methods of the abstract class
	
	//Implementing abstract methods of the abstract class
	public void firstAbstractMethod() {
		System.out.println("Implementing first abstract method");
	}
	
	public void secondAbstractMethod() {
		System.out.println("Implementing second abstract method");
	}
	
	public void thirdAbstractMethod() {
		System.out.println("Implementing third abstract method");
	}
}
public class Abstraction_11_AbstractClassAndMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Object of an abstract class can't be created, as it has a method which can't be called
		//as the method does not have implementation body
		//Following will give error, AbstractClass type can't be instantiated
		//Abstraction_11_AbstractClass abstractObject=new Abstraction_11_AbstractClass();
		
		Abstraction_11_ImplementationClass implementationObject = new Abstraction_11_ImplementationClass();
		implementationObject.firstAbstractMethod();
		implementationObject.secondAbstractMethod();
		implementationObject.thirdAbstractMethod();
		implementationObject.firstNonAbstractMethod();
	}

}
