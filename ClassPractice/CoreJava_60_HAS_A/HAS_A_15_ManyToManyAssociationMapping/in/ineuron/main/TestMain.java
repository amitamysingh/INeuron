package ClassPractice.CoreJava_60_HAS_A.HAS_A_15_ManyToManyAssociationMapping.in.ineuron.main;

import ClassPractice.CoreJava_60_HAS_A.HAS_A_15_ManyToManyAssociationMapping.in.ineuron.bean.Course;
import ClassPractice.CoreJava_60_HAS_A.HAS_A_15_ManyToManyAssociationMapping.in.ineuron.bean.Student;
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Course course1=new Course("A11", "JAVA", 1000);
		Course course2=new Course("B11", "PYTHON", 2000);
		Course course3=new Course("C11", "BLOCKCHAIN", 3000);
		
		Course[] courses = new Course[3];
		courses[0]=course1;
		courses[1]=course2;
		courses[2]=course3;
		
		Student s1=new Student("10", "sachin", "MI", courses);
		Student s2=new Student("7", "dhoni", "CSK", courses);
		Student s3=new Student("18", "kohli", "RCB", courses);
		
		s1.getStudentDetails();
		s2.getStudentDetails();
		s3.getStudentDetails();
	}

}
