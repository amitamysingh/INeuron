package ClassPractice.threadPractice;

class Thread_14 extends Thread{
	int total=0;
	
		public void run() {
			synchronized(this) {
				System.out.println("Child thread started the calculation"); //step-2
				for(int i=1;i<=100;i++) {
					total+=i;
				}
				System.out.println("Child thread giving notification call");//step-3
				this.notify();
			}
		}
}

public class Thread_14_NotifyWaitMethods {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread_14 thread=new Thread_14();
		thread.start();
		
		//2 threads: main thread(5), child thread(5)
		synchronized(thread) {
			System.out.println("main thread calling wait method"); //step-1
			thread.wait();
			System.out.println("main thread got notification call");//step-4
			System.out.println(thread.total);
		}
		
		
	}

}
