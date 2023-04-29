import java.util.Scanner;

public class Farmer{
	
	private float principalAmount;
	private float timeDuration;
	private static float rate;
	private float interest;
	
	static {
		rate=5.0f;
	}
	
	public void takeUserInput() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Principal Amount:: ");
		principalAmount=scanner.nextFloat();
		
		System.out.println("Enter the timeDuration::");
		timeDuration=scanner.nextFloat();
		
	}
	
	public void calculateInterest() {
		//rate= 5.0f;
		interest=(principalAmount*timeDuration*rate)/100;
	}
	
	public void displayInterest() {
		System.out.println(interest);
	}
}