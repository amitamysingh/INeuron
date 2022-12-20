package ClassPractice.threadPractice;

class MyThread_02 extends Thread{
	//run() method without arguments
	public void run() {
		System.out.println("No argument run method");
		
		//In order to run argumented run method, we need to call that method
		run(5);
	}
	
	//run() method with arguments
	public void run(int i) {
		System.out.println("Argumented run method");
	}
}

public class Thread_02_ArgumentedRunMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread_02 thread=new MyThread_02();
		//Start method will invoke no arguments run() method
		thread.start();
		
		//Also, we can explicitly call argumented run method
		thread.run(5);
		
		//Job of the main Thread
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread running");
		}

	}

}
