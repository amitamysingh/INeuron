package ClassPractice.CoreJava_40_Polymorphism;



class Polymorphism_11_Plane{
	
	public void carryItem() {
		System.out.println("Plane is carrying item");
	}
	
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

class Polymorphism_11_CargoPlane extends Polymorphism_11_Plane{
	
	//Specialized method
	public void carryItem() {
		System.out.println("Cargo Plane is carrying goods");
	}
	
	public void takeoff() {
		System.out.println("CargoPlane is taking off");
	}
	public void fly() {
		System.out.println("CargoPlane is flying");
	}
	
	public void land() {
		System.out.println("CargoPlane is landing");
	}
	
	
}

class Polymorphism_11_PassengerPlane extends Polymorphism_11_Plane{
	
	//Specialized method
	public void carryItem() {
		System.out.println("Passenger Plane is carrying passenger");
	}
	
	public void takeoff() {
		System.out.println("PassengerPlane is taking off");
	}
	public void fly() {
		System.out.println("PassengerPlane is flying");
	}
	
	public void land() {
		System.out.println("PassengerPlane is landing");
	}
	
	
}

class Polymorphism_11_FighterPlane extends Polymorphism_11_Plane{
	
	//Specialized method
	public void carryItem() {
		System.out.println("FighterPlane is carrying ammunition");
	}
	
	public void takeoff() {
		System.out.println("FighterPlane is taking off");
	}
	public void fly() {
		System.out.println("FighterPlane is flying");
	}
	
	public void land() {
		System.out.println("FighterPlane is landing");
	}
	
	
}

class Ploymorphism_11_Airport{
	
	//Reference is of parent class type
	//Hence, parent class taking form of various child item types
	public void permit(Polymorphism_11_Plane plane) {
		plane.carryItem();
		plane.takeoff();
		plane.fly();
		plane.land();
	}
}

public class Polymorphism_11_RuntimePolymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polymorphism_11_CargoPlane cargo=new Polymorphism_11_CargoPlane();
		Polymorphism_11_PassengerPlane passengerPlane=new Polymorphism_11_PassengerPlane();
		Polymorphism_11_FighterPlane fighterPlane=new Polymorphism_11_FighterPlane();
		
		Ploymorphism_11_Airport airport=new Ploymorphism_11_Airport();
		
		//Instead of calling different methods for different types of objects so many times
		//Need to call one method for different types of objects
		airport.permit(cargo);
		airport.permit(passengerPlane);
		airport.permit(fighterPlane);
		
		

	}

}
