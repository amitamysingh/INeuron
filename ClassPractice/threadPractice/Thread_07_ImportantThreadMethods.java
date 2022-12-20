package ClassPractice.threadPractice;


class Thread_07 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			//On Yield method encounter the current running thread will go back to ready/runnable state and then the thread scheduler will give a 
			//chance to any one of them(Current running thread or the thread where it has been called if same priority)
			Thread.yield();
			System.out.println("Child Thread");
		}
	}
}

public class Thread_07_ImportantThreadMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread_07 thread=new Thread_07();
		thread.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}

}
