package ClassPractice.CoreJava_40_Polymorphism;

class Polymorphism_12_Parent{
	public void cry() {
		System.out.println("Parent is crying");
	}
}
class Polymorphism_12_Child1 extends Polymorphism_12_Parent{
	
	public void cry() {
		System.out.println("Child1 is crying");
	}
	
	public void eat() {
		System.out.println("Child1 eats less");
	}
}

class Polymorphism_12_Child2 extends Polymorphism_12_Parent{
	
	public void cry() {
		System.out.println("Child2 is crying");
	}
	
	public void eat() {
		System.out.println("Child1 eats more");
	}
}
public class Polymorphism_12_DownCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ChildType object created with Parent type reference is upcasting
		Polymorphism_12_Parent child1=new Polymorphism_12_Child1();
		Polymorphism_12_Parent child2=new Polymorphism_12_Child2();
		
		child1.cry();
		
		//Using parent reference, child class specialized method can't be called
		//We need to cast the reference to the that of child type
		//This is called as DOWNCASTING
		((Polymorphism_12_Child1) child1).eat();
		
		child2.cry();		
		((Polymorphism_12_Child2) child2).eat();
	}

}
