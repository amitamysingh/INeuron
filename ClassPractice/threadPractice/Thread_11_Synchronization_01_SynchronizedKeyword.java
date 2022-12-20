package ClassPractice.threadPractice;

class Display_1{
	
	//Using access modifier 'synchronized' puts a lock(object level if the method is not static) on the thread, which will be released on at least 
	//one complete execution of the thread
	
	//At a time, on one thread, only one thread is working
	//It resolves data inconsistency 
	//It increases the waiting time and affects the performance 
	public synchronized void wish(String name) {
		for(int i=0;i<5;i++) {
			System.out.print("Good Morning:: ");
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				System.out.println("I am interrupted");
			}
			System.out.println(name);
		}
		
	}
}

class MyThread_11 extends Thread{
	Display_1 d;
	String name;
	MyThread_11(Display_1 d, String name){
		this.d=d;
		this.name=name;
	}
	public void run() {
		d.wish(name);
	}
}

public class Thread_11_Synchronization_01_SynchronizedKeyword {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display_1 d=new Display_1();
		MyThread_11 thread_1=new MyThread_11(d, "Sachin");
		MyThread_11 thread_2=new MyThread_11(d,"Dhoni");
		
		//We get irregular output (Data inconsistency)
		thread_1.start();
		thread_2.start();
	}
}
