package ClassPractice.threadPractice;

class Display_2{
	//If the method is marked as static, the lock is class level lock
	public static synchronized void displayNumbers() {
		for(int i=1;i<=10;i++) {
			System.out.print(i);
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted at displayNumbers");
			}
		}
	}
	public static synchronized void displayCharacters() {
		for(int i=65;i<=75;i++) {
			System.out.print((char)i);
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				System.out.println("Inteerrupted at displayCharacter");
			}
		}
	}
}
class MyThread_12_01 extends Thread{
	Display_2 d;
	MyThread_12_01(Display_2 d){
		this.d=d;
	}
	public void run() {
		d.displayNumbers();
	}
}

class MyThread_12_02 extends Thread{
	Display_2 d;
	MyThread_12_02(Display_2 d){
		this.d=d;
	}
	public void run() {
		d.displayCharacters();
	}
}

public class Thread_12_Synchronization_02_ClassLevelLock {
	public static void main(String[] args) {
		Display_2 display1=new Display_2();
		
		MyThread_12_01 thread1=new MyThread_12_01(display1);
		MyThread_12_02 thread2=new MyThread_12_02(display1);
		
		thread1.start();
		thread2.start();
		
		Integer x =48;
		//Block level Lock
		synchronized(x) {
			System.out.println(x);
		}
	}
	
}
