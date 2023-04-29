package ClassPractice.CoreJava_60_HAS_A.HAS_A_13_OneToManyAssociation.in.ineuron.main;

import ClassPractice.CoreJava_60_HAS_A.HAS_A_13_OneToManyAssociation.in.ineuron.bean.Interface_13_OneToManyAssociationDepartment;
import ClassPractice.CoreJava_60_HAS_A.HAS_A_13_OneToManyAssociation.in.ineuron.bean.Interface_13_OneToManyAssociationEmployee;


public class Interface_13_OneToManyAssociationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface_13_OneToManyAssociationEmployee emp1 = new Interface_13_OneToManyAssociationEmployee();
		Interface_13_OneToManyAssociationEmployee emp2 = new Interface_13_OneToManyAssociationEmployee();
		Interface_13_OneToManyAssociationEmployee emp3 = new Interface_13_OneToManyAssociationEmployee();
		
		emp1.setEmpId("10");
		emp1.setEmpName("sachin");
		emp1.setEmpAddr("MI");
		
		emp2.setEmpId("7");
		emp2.setEmpName("dhoni");
		emp2.setEmpAddr("CSK");
		
		emp3.setEmpId("18");
		emp3.setEmpName("Kohli");
		emp3.setEmpAddr("RCB");
		
		Interface_13_OneToManyAssociationEmployee[] emps=new Interface_13_OneToManyAssociationEmployee[3];
		emps[0]=emp1;
		emps[1]=emp2;
		emps[2]=emp3;
		
		Interface_13_OneToManyAssociationDepartment dept = new 
				Interface_13_OneToManyAssociationDepartment(12, "CRICKET", emps);
		dept.getDepartmentDetails();
		
	}

}
