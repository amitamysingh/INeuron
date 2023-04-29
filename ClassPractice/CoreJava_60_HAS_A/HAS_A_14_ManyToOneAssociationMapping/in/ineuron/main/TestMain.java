package ClassPractice.CoreJava_60_HAS_A.HAS_A_14_ManyToOneAssociationMapping.in.ineuron.main;

import ClassPractice.CoreJava_60_HAS_A.HAS_A_14_ManyToOneAssociationMapping.in.ineuron.bean.Branch;
import ClassPractice.CoreJava_60_HAS_A.HAS_A_14_ManyToOneAssociationMapping.in.ineuron.bean.Student;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Branch branch=new Branch();
		branch.setBranchId("IND10");
		branch.setBranchName("BCCI");
		
		Student std1=new Student();
		std1.setSid("10");
		std1.setSname("sachin");
		std1.setSaddr("MI");
		std1.setBranch(branch);
		
		Student std2=new Student();
		std2.setSid("7");
		std2.setSname("dhoni");
		std2.setSaddr("CSK");
		std2.setBranch(branch);
		
		Student std3=new Student();
		std3.setSid("18");
		std3.setSname("kohli");
		std3.setSaddr("RCB");
		std3.setBranch(branch);
		
		System.out.println("Students details are:: ");
		
		System.out.println("====================================");
		System.out.println("STDID is:: "+std1.getSid());
		System.out.println("STDNAME is:: "+std1.getSname());
		System.out.println("STDADDR is:: "+std1.getSaddr());
		System.out.println("BRANCHID is:: "+std1.getBranch().getBranchId());
		System.out.println("BRANCHNAME is:: "+std1.getBranch().getBranchName());
		System.out.println("====================================");
		
		System.out.println("====================================");
		System.out.println("STDID is:: "+std2.getSid());
		System.out.println("STDNAME is:: "+std2.getSname());
		System.out.println("STDADDR is:: "+std2.getSaddr());
		System.out.println("BRANCHID is:: "+std2.getBranch().getBranchId());
		System.out.println("BRANCHNAME is:: "+std2.getBranch().getBranchName());
		System.out.println("====================================");
		
		System.out.println("====================================");
		System.out.println("STDID is:: "+std3.getSid());
		System.out.println("STDNAME is:: "+std3.getSname());
		System.out.println("STDADDR is:: "+std3.getSaddr());
		System.out.println("BRANCHID is:: "+std3.getBranch().getBranchId());
		System.out.println("BRANCHNAME is:: "+std3.getBranch().getBranchName());
		System.out.println("====================================");
		
	}

}
