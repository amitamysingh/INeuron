package Assignments.simpleCRUDApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDInsert {

	
	
	public static void insertDetails() {
		
		//Resources used
		Connection connection = null;
		PreparedStatement insertStatement = null;
		Scanner scanner = null;
		
		String empName=null;
		Integer empAge= null;
		String empAddress=null;
		
		try {
			connection=JDBCUtility.getJdbcConnection();
			
			String sqlInsertQuery="insert into employeedetails (`empname`, `empage`, `empaddress`) values(?,?,?)";
			
			if(connection != null)
				insertStatement=connection.prepareStatement(sqlInsertQuery);
			
			if(insertStatement != null) {
				
				scanner = new Scanner(System.in);
				
				System.out.println("Enter the name of the employee:: ");
				empName=scanner.next();
				System.out.println("Enter the age of the employee:: ");
				empAge=scanner.nextInt();
				System.out.println("Enter the address of the employee:: ");
				empAddress=scanner.next();
				
				if(empName != null && empAge != null) {
					
					//
					insertStatement.setString(1, empName);
					insertStatement.setInt(2, empAge);
					insertStatement.setString(3, empAddress);
					
					//Execute the query
					int rowCount=insertStatement.executeUpdate();
					System.out.println("Number of rows updated:: "+rowCount);
				}else {
					System.out.println("Employee Name and Age are mandatory");
				}
			}
			
		}catch(SQLException se){
			System.out.println("SQL Exception found in InsertApp");
			se.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Exception found in InsertApp");
			e.printStackTrace();
		}
		finally {
			try {
				
				System.out.println("Cleaning up resources");
				JDBCUtility.cleanUp(connection, insertStatement, null);
				
			}catch(SQLException se) {
				
				System.out.println("Exception found in cleaning up InsertApp");
				se.printStackTrace();
				
			}
			catch(Exception e) {
				
				System.out.println("Exception found in cleaning up InsertApp");
				e.printStackTrace();
			}
		}
	}
}
