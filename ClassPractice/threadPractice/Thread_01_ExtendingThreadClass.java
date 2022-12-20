package ClassPractice.threadPractice;

/*
 * class Thread{
 *		//Heart of MultiThreading
 * 		public void start(){
 * 			1. Register the thread with Thread Scheduler
 * 			2. All other mandatory low level activities
 * 			3. invoke or call run()
 * 		}
 * 		public void run(){
 * 			//no implementation
 * 		}
 * }
 */

class MyThread_01 extends Thread {
	
	//Task2 
	@Override
	public void run() {
		//Task for child Thread
		for(int i=0;i<5;i++) {
			System.out.println("Child Thread");
		}
	}		
}


public class Thread_01_ExtendingThreadClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread_01 thread=new MyThread_01();
		
		//This line will create a new Thread and execute run()
		thread.start();
		
		//Two tasks waiting for CPU time, scheduling is to be done by TS
		
		//Task for main Thread
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread");
		}
	}

}
