package ClassPractice.CoreJava_60_HAS_A.HAS_A_15_ManyToManyAssociationMapping.in.ineuron.bean;

//Target Object
public class Student {
	private String sid;
	private String sname;
	private String saddr;
	
	//HAS-A
	private Course courses[];
	
	//Constructor Injection
	public Student(String sid, String sname, String saddr, Course[] courses) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.saddr = saddr;
		this.courses = courses;
	}
	
	//Student Details
	public void getStudentDetails() {
		System.out.println("Student Details::");
		System.out.println("==================================");
		System.out.println("SID is:: " + sid);
		System.out.println("SNAME is:: " + sname);
		System.out.println("SADDR is:: " + saddr);
		System.out.println();
		
		System.out.println("Course Details::");
		System.out.println("----------------------------");
		for(Course c : courses) {
			System.out.println("COURSEID is:: "+c.courseid);
			System.out.println("COURSENAME is:: "+c.courseName);
			System.out.println("COURSECOST is:: "+c.courseCost);
			System.out.println("----------------------------");
		}
		System.out.println("==================================");
		
	}
	
	
}
