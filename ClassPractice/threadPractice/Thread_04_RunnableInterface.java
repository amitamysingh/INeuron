package ClassPractice.threadPractice;

class MyRunnable_01 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Child Thread");
		}
	}
}
public class Thread_04_RunnableInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyRunnable_01 runnable=new MyRunnable_01();
		
		// If we create a Thread object with 0 arguments constructor, it will run() method present in the Thread class and not the Overridden run()
		// method that we have defined in the MyRunnable class, as it has been overridden from Runnable interface directly and thread method had not 
		// part in it
		//Final result -> No job to run() method[of Thread class] hence, empty child Thread
		//Thread thread = new Thread();
		
		
		//If we use the following constructor, Thread class start method will be invoked with Runnable interface run() method
		Thread thread = new Thread(runnable);
		
		//If we invoke start() method without Thread class, it will throw error as start() method is a part of Thread class
		thread.start();
		//Two thread at this point Main Thread and user-defined thread
		
		
		//If we call run() method directly using runnable.run(), no new thread will be created, it will run like a normal method call
		
		for(int i=0;i<5;i++) {
			System.out.println("Main Thread");
		}

	}

}
