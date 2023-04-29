package ClassPractice.CoreJava_80_Interfaces;

interface IVariables_12_Interface{
	
	//any variable in an interface is by default public static final
	//Hence we can't use few access modifiers like protected,transient
	//And we have to give some value while declaration, otherwise we will get error
	
	//Following will give error, blank final field cannot be initialised
	//int a;
	
	//This variable will be present in methodarea i.e, it is a class data
	int a=10; 
	public void showVariables();
}

class SampleImpl_12_Interface implements IVariables_12_Interface{
	//a=10;
	public void showVariables() {
		System.out.println("Variable a is:: "+a);
	}
}

class SecondSampleImpl_12_Interface implements IVariables_12_Interface{
	//This variable which is defined inside a class will be present in stack area, hence, jvm will reach out to this variable
	//If the variable is not found in stack area, it will go to methodarea to find the variable
	//Hence output will be 20
	int a=20;
	public void showVariables() {
		System.out.println("Variable a when defined in the class implementing interface is:: "+a);
		System.out.println("Interface.variable will print the value directly from the interface:: "+IVariables_12_Interface.a);
	}
}
public class Interface_12_Variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IVariables_12_Interface object =new SampleImpl_12_Interface();
		object.showVariables();
		
		IVariables_12_Interface secondObject =new SecondSampleImpl_12_Interface();
		secondObject.showVariables();
		
	}

}
