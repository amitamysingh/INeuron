package ClassPractice.threadPractice;

class MyThread_09 extends Thread{
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				
				System.out.println("I am a sleeping Thread:: "+i);
				
				//If the child thread does not go to wait or sleep state, the interrupt call will be wasted (Comment the below line and see)
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			System.out.println("I got interrupted");
		}
		
	}
	
}

public class Thread_09_Interruption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread_09 thread=new MyThread_09();
		
		thread.start();
		//If the child thread goes to sleep or waiting state, in that case interrupt method will interrupt the child thread
		thread.interrupt();
		
		System.out.println("End of main Thread");
	}

}
