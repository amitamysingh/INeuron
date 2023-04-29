package ClassPractice.CoreJava_30_Inheritance;

class Demo2{
	int a;
	int b;
	
	public Demo2(){
		a=10;
		b=20;
		System.out.println("Parent Class zero parameterized constructor");
	}
	public Demo2(int a, int b){
		this.a=a;
		this.b=b;
		System.out.println("Parent Class parameterized constructor");
	}
}
class Demo22 extends Demo2{
	
	int x;
	int y;
	
	public Demo22() {
		x=100;
		y=200;
		System.out.println("Child class zero parameterized constructor");
	}
	
	public Demo22(int x, int y) {
		this.x=x;
		this.y=y;
		System.out.println("Child class parameterized constructor");
	}
	
	public void display() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(x);
		System.out.println(y);
	}
}

public class Inheritance_12_ConstructorInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo22 demo22=new Demo22();
		demo22.display();
		Demo22 demo221=new Demo22(30,60);
		demo221.display();
	}

}
