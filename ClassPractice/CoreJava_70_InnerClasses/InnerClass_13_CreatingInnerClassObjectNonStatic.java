package ClassPractice.CoreJava_70_InnerClasses;


class InnerClass_13_OuterClass{
	
	private int num=10;
	
	//Creating the object of the inner class outside the inner class but inside outer class
	InnerClass_13_InnerClass innerObject = new InnerClass_13_InnerClass();
	
	
	public void show() {
		System.out.println("Method in outer class");
		
		
	}
	
	
	class InnerClass_13_InnerClass{
		
		public void config() {
			System.out.println();
			System.out.println("Method in inner class");
			
			System.out.println("Inner Class can access private instances of outer class e.g,  num:: "+num);
			System.out.println();
				
		}
			
		}
	}

public class InnerClass_13_CreatingInnerClassObjectNonStatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
				InnerClass_13_OuterClass outerObject = new InnerClass_13_OuterClass();
				outerObject.show();
				
				
				InnerClass_13_OuterClass.InnerClass_13_InnerClass innerObject;
				//Inner Object can be created using outerObject.new keyword
				innerObject= outerObject.new InnerClass_13_InnerClass();
				
				//Now inner class method can be accessed
				innerObject.config();
	}

}
