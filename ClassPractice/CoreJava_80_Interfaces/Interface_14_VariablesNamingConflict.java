package ClassPractice.CoreJava_80_Interfaces;

interface ISample_14_firstInterface{
	int x=8888;
}

interface ISample_14_secondInterface{
	int x=9999;
}

class SampleImpl_14_Interfaces implements ISample_14_firstInterface,ISample_14_secondInterface{
	
	public void show() {
		//Following will return compile time error - ambiguous
		//System.out.println(x);
		
		//But we can access variables using interface.variables
		System.out.println("Variable in the first interface:: "+ISample_14_firstInterface.x);
		System.out.println("Variable in the first interface:: "+ISample_14_secondInterface.x);
	}
	
}

public class Interface_14_VariablesNamingConflict {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SampleImpl_14_Interfaces object=new SampleImpl_14_Interfaces();
		object.show();
		

	}

}
