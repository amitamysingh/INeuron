package ClassPractice.CoreJava_60_HAS_A.HAS_A_13_OneToManyAssociation.in.ineuron.bean;

public class Interface_13_OneToManyAssociationDepartment {
	private int deptId;
	private String deptName;
	
	//HAS-A Employee
	private Interface_13_OneToManyAssociationEmployee emps[];

	public Interface_13_OneToManyAssociationDepartment(int deptId, String deptName,
			Interface_13_OneToManyAssociationEmployee[] emps) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.emps = emps;
	}
	
	public void getDepartmentDetails() {
		System.out.println("Department Details");
		System.out.println("----------------------------");
		System.out.println("DEPTID is:: "+deptId);
		System.out.println("DEPTNAME is:: "+deptName);
		System.out.println("----------------------------");
		System.out.println();
		System.out.println("Employee Details");
		System.out.println("----------------------------");
		for(Interface_13_OneToManyAssociationEmployee employee : emps) {
			System.out.println("EMPID is:: "+ employee.getEmpId());
			System.out.println("EMPNAME is:: "+ employee.getEmpName());
			System.out.println("EMPADDR is:: "+ employee.getEmpAddr());
			System.out.println();
		}
	}
}
