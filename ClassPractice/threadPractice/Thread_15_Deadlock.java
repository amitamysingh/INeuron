package ClassPractice.threadPractice;

class A{
	public synchronized void d1(B b) {
		System.out.println("Thread-1 starts execution of d1");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.out.println("Thread-1 interrupted");
		}
		System.out.println("Thread-1 trying to call b last()");
		b.last();
	}
	public synchronized void last() {
		System.out.println("Inside A last method");
	}
}

class B{
	public synchronized void d2(A a) {
		System.out.println("Thread-2 starts execution of d2");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			System.out.println("Thread-2 interrupted");
		}
		System.out.println("Thread-2 trying to call a last method");
		a.last();
	}
	//On synchronizing last method of both A and B the condition of dead lock arises
	//A will wait for lock of B and B will wait for lock of A
	public synchronized void last() {
		System.out.println("Inside B last method");
	}
}

public class Thread_15_Deadlock extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		B b=new B();
	}

}
