package ClassPractice.CoreJava_60_HAS_A.HAS_A_12_OneToOneAssociationMapping.in.ineuron.bean;

//
public class Inheritence_12_OneToOneAssociationMapping_Employee {
	
	private int empId;
	private String empName;
	private String empAddr;
	
	//HAS-A Relationship
	private Inheritence_12_OneToOneAssociationMapping_Accounts account;
	
	public Inheritence_12_OneToOneAssociationMapping_Employee(int empId, String empName, String empAddr, 
			Inheritence_12_OneToOneAssociationMapping_Accounts account) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddr = empAddr;
		this.account=account;
	}
	
	public void getEmployeeDetails() {
		System.out.println("Employee Details are::");
		System.out.println("EMPID is:: "+ empId);
		System.out.println("EMPNAME is:: "+ empName);
		System.out.println("EMPADDR is:: "+ empAddr);
		System.out.println("===============================");
		System.out.println("Account Details are::");
		System.out.println("ACCNO is:: "+ account.accNo);
		System.out.println("ACCNAME is:: "+ account.accName);
		System.out.println("ACCTYPE is:: "+ account.accType);
	}
	
	

}
