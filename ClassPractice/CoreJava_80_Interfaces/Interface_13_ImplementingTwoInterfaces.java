package ClassPractice.CoreJava_80_Interfaces;


interface ISample_13_FirstInterface{
	public void firstMethod();
}
/*
 *Case 2
 
 //Two interfaces have same method signature, but different return types
//It will throw error as jvm checks the method signature in this case and not the return type
//We can't have duplicate methods
		 
interface ISample_13_SecondInterface{
	public int firstMethod();
}

*/

//Case 3
//Method have same return type but different signature
//This is a valid case as method signature is different, hence no error will be thrown
interface ISample_13_SecondInterface{
	public void firstMethod(int a);
}
//A class can implement 2 interfaces at same time, but 
class SampleImpl_13_Interfaces implements ISample_13_FirstInterface,ISample_13_SecondInterface{
	
	public void firstMethod() {
		System.out.println("Returning void method");
	}
	/* Case 2
	public int firstMethod() {
		System.out.println("Returning int method");
		return 23;
	}
	*/
	
	//Case 3
	public void firstMethod(int a) {
		System.out.println("Returning void method which takes integer parameter a as:: "+a);
	}
	
	
}

public class Interface_13_ImplementingTwoInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleImpl_13_Interfaces object = new SampleImpl_13_Interfaces();
		object.firstMethod();
		object.firstMethod(10);
	}

}
