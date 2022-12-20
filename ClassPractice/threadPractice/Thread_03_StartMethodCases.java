package ClassPractice.threadPractice;

class MyThread_03 extends Thread{
	
	@Override
	public void start() {
		// When super.start() method is called, start method of Thread class is called and then a new Thread is created i.e, user-defined thread
		super.start();
		
		//Without super.start(), overridden run method will not be reached, as start method in thread class internally makes a call to run() method
		//New user-defined will not be created without super.start() method as Overridden start method will be called and Thread class start method will
		// not be called
		System.out.println("Overridden start method");
		
	}
	@Override
	public void run() {
		System.out.println("Userdefined Thread run() method");
	}
}

public class Thread_03_StartMethodCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread_03 thread=new MyThread_03();
		thread.start();
		
		System.out.println("Main Thread");

	}

}
