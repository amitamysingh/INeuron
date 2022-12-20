package ClassPractice.threadPractice;

//Daemon thread is a supporting Thread
class Thread_15 extends Thread{
	
}

public class Thread_16_DamonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().isDaemon());
		
		Thread_15 thread=new Thread_15();
		//Child thread is not a Daemon thread until it is declared so
		thread.setDaemon(true);
		//Current thread(main thread) can't be set as Daemon thread
		//We get illegal ThreadStateException
		//Thread.currentThread().setDaemon(true);
		
		thread.start();
		System.out.println(thread.isDaemon());
	}

}
