package ClassPractice.CoreJava_80_Interfaces;

interface ISample_11_Interface{
	public void method1();
	public void method2();
}

//A class which implements an interface but does not defines all its methods have the un-defined method by default as public abstract m()
//Hence the class is abstract and must be marked as abstract otherwise we will get error
abstract class SampleImpl_11_AbstractClass implements ISample_11_Interface{
	public void method1() {
		System.out.println("Method1 defined in abstract class after implementing interface,"
				+ " but not method2 due to which it becomes abstract class");
	}
	
}

class SubSampleImpl_11_ConcreteClass extends SampleImpl_11_AbstractClass{
	public void method2() {
		System.out.println("Method2 implemented in concrete class");
	}
}

public class Interface_11_InterfaceAbstractConcreteClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Polymorphism used where parent interface reference is used to create a child class object
		//Loose coupling is achieved using this
		ISample_11_Interface sampleObject=new SubSampleImpl_11_ConcreteClass();
		sampleObject.method1();
		sampleObject.method2();

	}

}
