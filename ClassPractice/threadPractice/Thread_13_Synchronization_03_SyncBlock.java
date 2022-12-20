package ClassPractice.threadPractice;

class Display_3 {
	public void wish(String name) {
		;;;;;;;;;;;;;; //Some logic
		
		//Till above synchronized block, all the thread will get chance
		//System.out.println("Thread which is getting the lock is:: "+Thread.currentThread().getName());
		
		//Using Synchronized Block we will get regular output, which is not the case otherwise
		synchronized(this) {
			//Inside synchronized block only one thread will get a chance at a time
			System.out.println("Thread which is getting the lock is:: "+Thread.currentThread().getName());

			for(int i=0;i<5;i++) {
				System.out.print("Good Morning:: ");
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					System.out.println("I am interrupted");
				}
				System.out.println(name);
			}
			
		}
		System.out.println("Thread which is releasing the lock is:: "+Thread.currentThread().getName());
		;;;;;;;;;;;; //Some other logic
	}
}

class MyThread_13 extends Thread{
	Display_3 d;
	String name;
	
	MyThread_13(Display_3 d, String name){
		this.d=d;
		this.name=name;
	}
	public void run() {
		d.wish(name);
	}
}

public class Thread_13_Synchronization_03_SyncBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display_3 d=new Display_3();
		
		MyThread_13 thread1=new MyThread_13(d, "Yuvi");
		MyThread_13 thread2=new MyThread_13(d, "Dhoni");
		thread1.setName("Yuvi Thread");
		thread2.setName("Dhoni Thread");
		thread1.start();
		thread2.start();
	}
	//Try creating two objects of Display and check whether we are getting regular output
	//Try creating two object and apply class level lock to check whether we are getting regular output

}
