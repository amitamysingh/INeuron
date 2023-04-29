package ClassPractice.CoreJava_30_Inheritance;

class Plane{
	
	public void takeoff() {
		System.out.println("Plane is taking off");
	}
	public void fly() {
		System.out.println("Plane is flying");
	}
	
	public void land() {
		System.out.println("Plane is landing");
	}
}

class CargoPlane extends Plane{
	
	//Specialized method
	public void carryGoods() {
		System.out.println("Cargo Plane is carrying goods");
	}
	
	//Overridden method
	//visibility should not decrease
	//Following will throw error
	//void fly() or protected void fly()
	public void fly() {
		System.out.println("CargoPlane is flying at low height");
	}
	
	
}

class PassengerPlane extends Plane{
	
	//Specialized method
	public void carryPassenger() {
		System.out.println("Passenger Plane is carrying passenger");
	}
	//Overridden method
	//return type cannot be changed except for co-variant type i.e 
	//return type can have parent-child relationship
	//following will give error
	//public String fly()
	public void fly() {
		System.out.println("PassengerPlane is flying at medium height");
	}
	
	
}

public class Inheritance_13_OverriddenAndSpecialisedMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CargoPlane cargo=new CargoPlane();
		PassengerPlane passengerPlane=new PassengerPlane();
		
		cargo.takeoff();
		cargo.fly();
		cargo.carryGoods();
		cargo.land();
		
		passengerPlane.takeoff();
		passengerPlane.fly();
		passengerPlane.carryPassenger();
		passengerPlane.land();

	}

}
