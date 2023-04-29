package ClassPractice.CoreJava_70_InnerClasses;

//Creating outer class as static is not allowed, we get illegal modifier
/* static */ class InnerClass_12_OuterClass{
	
	//the instance needs to be changed to static so static class can access it
	private static int num=10;
	
	//Creating the object of the inner class outside the inner class but inside outer class
	InnerClass_12_InnerClass innerObject = new InnerClass_12_InnerClass();
	
	
	public void show() {
		System.out.println("Method in outer class");
		
		
	}
	
	//Inner class can be made static, only inner class can be defined as static class
	static class InnerClass_12_InnerClass{
		
		public void config() {
			System.out.println();
			System.out.println("Method in inner class");
			//After making the class as static, the private variables of outer class can't be accessed directly, 
			//we need to change the instance to static
			System.out.println("Inner Class can access private instances of outer class e.g,  num:: "+num);
			System.out.println();
				
		}
			
		}
	}


public class InnerClass_12_CreatingInnerClassObjectStaticClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creating object of Outer class and calling its method
		InnerClass_12_OuterClass outerObject = new InnerClass_12_OuterClass();
		outerObject.show();
		
		//We can't access the method of inner class using outer class object
		//Following is not allowed
		//outerObject.config();
		
		//Hence, we need to create object of inner class
		//But we can't create object of inner class directly as of outer class using new keyword
		//Following is not allowed
		//InnerClass_12_InnerClass innerObject=new InnerClass_12_InnerClass();
		
		//Hence we need to create innerObject using OuterClass.InnerClass 
		InnerClass_12_OuterClass.InnerClass_12_InnerClass innerObject;
		//Since inner class is static, we can access constructor of inner class using OuterClass.InnerClass()
		innerObject= new InnerClass_12_OuterClass.InnerClass_12_InnerClass();
		
		//Now inner class method can be accessed
		innerObject.config();
		
	}

}
