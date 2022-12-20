package ClassPractice.threadPractice;
// What happens if we don't synchronize?

class Display{
	public void wish(String name) {
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

class MyThread_10 extends Thread{
	Display d;
	String name;
	MyThread_10(Display d, String name){
		this.d=d;
		this.name=name;
	}
	public void run() {
		d.wish(name);
	}
}
public class Thread_10_SynchronizationNeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d=new Display();
		MyThread_10 thread_1=new MyThread_10(d, "Sachin");
		MyThread_10 thread_2=new MyThread_10(d,"Dhoni");
		
		//We get irregular output (Data inconsistency)
		thread_1.start();
		thread_2.start();
	}

}
