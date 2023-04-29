package ClassPractice.CoreJava_60_HAS_A;

class Interface_11_Student{
	private String sname;
	private Integer sage;
	private Integer sid;
	
	//Constructor to set the value
	public Interface_11_Student(String sname, Integer sage, Integer sid) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.sid = sid;
	}
	
	//Setters and getters to set and retrieve the value
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sage=" + sage + ", sid=" + sid + "]";
	}
	
	
	
}

public class Interface_11_PremitiveValueInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface_11_Student student=new Interface_11_Student("Amit", 24, 28);
		System.out.println(student);
	}

}
