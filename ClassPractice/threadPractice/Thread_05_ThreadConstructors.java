package ClassPractice.threadPractice;

class MyThread_05 extends Thread {
	public void run() {
		System.out.println("Child Thread");
	}
}

public class Thread_05_ThreadConstructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread_05 myThread=new MyThread_05();
		
		//Using following constructor we can't create a new thread, as it will be making a call to Thread class run method
		//Thread thread=new Thread();	
		
		//The use of following constructor will invoke run() method of MyThread class
		Thread thread=new Thread(myThread);
		thread.start();
		
		System.out.println("Main Thread");
		
		//Thread Methods
		
		// We can set the name for a Thread. Two threads can be given same name but it is not recommended
		Thread.currentThread().setName("Yash");
		//If we do not set the name, the default name for main thread is "main"
		String name=Thread.currentThread().getName();
		System.out.println("Current Thread is being executed by:: "+name);
		
		System.out.println("Child Thread is being executed by:: "+myThread.getName());
	}

}
