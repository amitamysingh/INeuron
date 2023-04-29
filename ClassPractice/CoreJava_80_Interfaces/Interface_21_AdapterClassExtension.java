package ClassPractice.CoreJava_80_Interfaces;

interface ISample_21_AdapterInterface{
	public void m1();
	public void m2();
	public void m3();
	public void m4();
	public void m5();
}

class AdapterClass_21_Interface implements ISample_21_AdapterInterface{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
	public void m5() {}
}

class AdaptedClass_21_Implementation extends AdapterClass_21_Interface{
	public void m3() {
		System.out.println("I am implementation of m3 via adapted class");
	}
}
public class Interface_21_AdapterClassExtension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ISample_21_AdapterInterface object = new AdaptedClass_21_Implementation();
		object.m3();
		
		//Following will not give any results
		object.m1();
	}

}
