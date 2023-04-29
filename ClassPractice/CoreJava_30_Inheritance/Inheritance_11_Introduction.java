package ClassPractice.CoreJava_30_Inheritance;

public class Inheritance_11_Introduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Demo11 demo=new Demo11();
		demo.display();
		//System.out.println("")
		
	}

}

class Demo1{
	private String name="Amit";
	private int age=26;
	
	public Demo1() {
		System.out.println("Parent constructor");
	}
	
	public void display() {
		System.out.println("Demo1 "+age+" "+name);
	}
}

//Extending to Demo1, Demo2 can inherit all the properties and methods of Demo1
//Demo1 is the parent class
//Demo2 is the child/Derived class
//Private members will not participate in inheritence
class Demo11 extends Demo1{
	//Following will give error
	//age=28;
	
	//Constructor will not participate in inheritance, however super class constructor will be called
	//due to super() present in the child class constructor by default
	//Parent class constructor is also called
	//This is by default
	//Demo2(){
		//super();
	//}
	
}
