package in.ineuron;


class SwapApp{
	int a,b;
	
	public void accept(int x, int y){
		a=x;
		b=y;

	}
	public void swapvalues(){
		a=a+b;
		b=a-b;
		a=a-b;

	}
	public void display(){
		System.out.println("Value of a= "+a);
		System.out.println("Value of b= "+b);

	}
}
public class SwapDemoApp 
{
    public static void main( String[] args )
    {
        if(args.length != 2){
		System.out.println("Please enter 2 numbers");
	}
	else{
		int x1=Integer.parseInt(args[0]);
		int x2=Integer.parseInt(args[1]);
	

	SwapApp s = new SwapApp();
	s.accept(x1,x2);
	System.out.println("Before Swapping");
	System.out.println("---------------");
	System.out.println();
	s.display();
	s.swapvalues();
	System.out.println("After Swapping");
	System.out.println("---------------");
	s.display();
	}
    }
}
