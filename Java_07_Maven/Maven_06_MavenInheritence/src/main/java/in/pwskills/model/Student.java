package in.pwskills.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    public Student(){
        System.out.println("Hibernate uses zero argument constructor");
    }
    @Id
    private int stdid;
    private String sname;
    private int sage;
    private String saddress;

    public int getStdid() {
        return stdid;
    }

    public void setStdid(int stdid) {
        this.stdid = stdid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "GetRecordApp{" +
                "stdid=" + stdid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                '}';
    }

}
