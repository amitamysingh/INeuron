package ClassPractice.threadPractice;

class MyThread_06 extends Thread{
	public void run() {
		//Without setting up the priority, we get the priority as 5 for both main and child threads
		System.out.println("Priority of a Child Thread is:: "+Thread.currentThread().getPriority() );
	}
}
public class Thread_06_PriorityOfThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread_06 thread =new MyThread_06();
		thread.start();
		
		//Setting the priority of a Thread
		thread.setPriority(10);
		
		System.out.println("Priority of main Thread is:: "+Thread.currentThread().getPriority());
		
		//Min to max priority
		System.out.println("Minimum priority:: "+Thread.MIN_PRIORITY);
		System.out.println("Normal priority:: "+Thread.NORM_PRIORITY);
		System.out.println("Maximum priority:: "+Thread.MAX_PRIORITY);
		
		//Following will produce IllegalArgumentException
		thread.setPriority(100);
	}

}
