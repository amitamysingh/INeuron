package ClassPractice.CoreJava_70_InnerClasses;

class InnerClass_11_OuterClass{
	
	private int num=10;
	
	//Creating the object of the inner class outside the inner class but inside outer class
	InnerClass_11_InnerClass innerObject = new InnerClass_11_InnerClass();
	
	
	public void show() {
		System.out.println("Method in outer class");
		//Calling the method of inner class outside inner class
		System.out.println("Calling inner class method from outer class method");
		innerObject.config();
		
	}
	
	class InnerClass_11_InnerClass{
		
		public void config() {
			System.out.println();
			System.out.println("Method in inner class");
			System.out.println("Inner Class can access private instances of outer class e.g,  num:: "+num);
			System.out.println();
		}
	}
}

public class InnerClass_11_CreatingInnerClass {
	public static void main(String[] args) {
		InnerClass_11_OuterClass outerObject = new InnerClass_11_OuterClass();
		outerObject.show();
	}

}
