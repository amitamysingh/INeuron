package ClassPractice.JDBCPractice;

import java.io.FileWriter;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JDBC_98_WebRowSetSelectApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();
		WebRowSet wrs = rsf.createWebRowSet();//same as resultset(connected),  but updatable and scrollable
		
		//setting url, username,password
		wrs.setUrl("jdbc:mysql://localhost:3306/mydb");
		wrs.setUsername("root");
		wrs.setPassword("root");
		
		//setting a command for execution
		wrs.setCommand("select sid, sname,sage,saddress,sgender from student");
		wrs.execute();
		
		//
		FileWriter fw = new FileWriter("std.xml");
		wrs.writeXml(fw);
		System.out.println("Employee Data transferred to std.xml");
		fw.close();
	}

}
