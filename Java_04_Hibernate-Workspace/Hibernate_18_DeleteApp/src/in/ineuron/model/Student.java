package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

@Entity
//No Need to use @Table(name='')
//The table will be generated based on the Entity Name
//@Table(name="STDTAB")
//Using Dynamic Insert, only those values will be inserted which are set in the code
@DynamicInsert(value=true)
public class Student {
	
	@Id
	//No need to use @Column(name='') as the columns will be generated by pre-generated query
	@Column(name="stdId")
	private int sid;
	private String sname;
	private String saddress;
	
	

	public Student() {
		System.out.println("Zero Parameter Constructor used by hibernate");
	}
	
	public int getSid() {
		return sid;
	}




	public void setSid(int sid) {
		this.sid = sid;
	}




	public String getSname() {
		return sname;
	}




	public void setSname(String sname) {
		this.sname = sname;
	}




//	public int getSage() {
//		return sage;
//	}
//
//
//
//
//	public void setSage(int sage) {
//		this.sage = sage;
//	}




	public String getSaddress() {
		return saddress;
	}




	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}




	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
	
	
	
}