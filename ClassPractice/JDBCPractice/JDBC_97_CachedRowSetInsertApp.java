package ClassPractice.JDBCPractice;


import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;



public class JDBC_97_CachedRowSetInsertApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs=rsf.createCachedRowSet();
		
		
		crs.setUrl("jdbc:mysql://localhost:3306/mydb");
		crs.setUsername("root");
		crs.setPassword("root");
		
		crs.setCommand("select empid,empname,emplocation,empdept,empsalary from employees");
		crs.execute();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Enter the id of the employee:: ");
			int empId=scanner.nextInt();
			
			System.out.println("Enter the name of the employee:: ");
			String empName=scanner.next();
			
			System.out.println("Enter the location of the employee:: ");
			String empLocation=scanner.next();
			
			System.out.println("Enter the dept of the employee:: ");
			String empDept=scanner.next();
			
			System.out.println("Enter the salary of the employee:: ");
			int empSalary=scanner.nextInt();
			
			crs.moveToInsertRow();
			
			crs.updateInt(1, empId);
			crs.updateString(2, empName);
			crs.updateString(3, empLocation);
			crs.updateString(3, empDept);
			crs.updateInt(5, empSalary);
			
			crs.insertRow();
			
			System.out.println("Record inserted successfully...");
			System.out.println("Do you want to insert more record - [Yes/No]:: ");
			String options=scanner.next();
			
			if(options.equalsIgnoreCase("No"))
				break;
			
			crs.moveToCurrentRow();
			crs.acceptChanges();//even if the connection gets disconnected the record should be added
		}	
		crs.close();
		scanner.close();
	}
}
