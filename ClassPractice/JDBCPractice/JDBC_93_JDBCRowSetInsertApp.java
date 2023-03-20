package ClassPractice.JDBCPractice;

import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBC_93_JDBCRowSetInsertApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		
		//setting url,username,password and getting the connection object
		jrs.setUrl("jdbc:mysql://localhost:3306/mydb");
		jrs.setUsername("root");
		jrs.setPassword("root");
		
		//setting a command for execution
		jrs.setCommand("select sid,sname,sage,saddress,sgender from student");
		jrs.execute();
		
		Scanner scanner = new Scanner(System.in);
		jrs.moveToInsertRow();
		
		while(true) {
			System.out.println("Enter the name:: ");
			String name=scanner.next();
			
			System.out.println("Enter the age:: ");
			int age=scanner.nextInt();
			
			System.out.println("Enter the address:: ");
			String address=scanner.next();
			
			System.out.println("Enter the gender:: ");
			String gender=scanner.next();
			
			jrs.updateString(2, name);
			jrs.updateInt(3, age);
			jrs.updateString(4, address);
			jrs.updateString(5, gender);
			
			jrs.insertRow();
			
			System.out.println("Record inserted successfully...");
			System.out.println("Do you want to insert more records - [Yes/No]:: ");
			String options=scanner.next();
			if(options.equalsIgnoreCase("No"))
				break;
		}
		scanner.close();
		jrs.close();
	}

}
