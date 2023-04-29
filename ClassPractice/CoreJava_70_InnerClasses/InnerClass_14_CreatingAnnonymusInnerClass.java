package ClassPractice.CoreJava_70_InnerClasses;

class InnerClass_14_OuterClass{
	
	public void config() {
		System.out.println("In outer class config");
	}
}
public class InnerClass_14_CreatingAnnonymusInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClass_14_OuterClass object = new InnerClass_14_OuterClass()
				{
					public void config() {
						System.out.println("In inner class config");
					}
				};
		object.config();
	}

}
