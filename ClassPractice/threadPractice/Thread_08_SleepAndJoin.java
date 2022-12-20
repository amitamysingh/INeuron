package ClassPractice.threadPractice;

class Thread_08 extends Thread{
	public void run() {
		try {
			for(int i=0;i<5;i++) {
				
				//Sleep method will stop the execution of a thread for the time amount mentioned
				//Thread.sleep is a checked exception, hence we need to surround it with try-catch
				Thread.sleep(2000);
				System.out.println("Sita Thread");
			}
		}catch(InterruptedException e) {
			
		
		}
	}
}
public class Thread_08_SleepAndJoin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread_08 thread=new Thread_08();
		thread.start();
		
		//Join method without time argument will wait for the joinee thread to finish up the execution and then current thread will execute
		//thread.join();
		
		//Join method with time parameter will wait for that time amount after that current thread will execute, no matter if joinee thread 
		// executes within that much time or not
		thread.join(1000);
		
		//Following will wait forever as join is called on the same thread(itself), which is condition of deadlock
		//Thread.currentThread().join();
		
		for(int i=0;i<5;i++) {
			System.out.println("Rama Thread");
		}
	}

}
