package ClassPractice.CoreJava_60_HAS_A.HAS_A_12_OneToOneAssociationMapping.in.ineuron.main;

import ClassPractice.CoreJava_60_HAS_A.HAS_A_12_OneToOneAssociationMapping.in.ineuron.bean.Inheritence_12_OneToOneAssociationMapping_Accounts;
import ClassPractice.CoreJava_60_HAS_A.HAS_A_12_OneToOneAssociationMapping.in.ineuron.bean.Inheritence_12_OneToOneAssociationMapping_Employee;



public class Interface_12_OneToOneAssociationMappingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inheritence_12_OneToOneAssociationMapping_Accounts accounts = 
				new Inheritence_12_OneToOneAssociationMapping_Accounts(12, "sachin", "Saving");
		
		//Constructor Injection
		Inheritence_12_OneToOneAssociationMapping_Employee employee = 
				new Inheritence_12_OneToOneAssociationMapping_Employee(2, "sachin tendulakr", "MI", accounts);
		
		employee.getEmployeeDetails();
	}

}
