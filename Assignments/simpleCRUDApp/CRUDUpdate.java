package Assignments.simpleCRUDApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDUpdate {
	
	public static void updateDetails(){
		//Resources used
		Connection connection=null;
		PreparedStatement updateStatement=null;
		PreparedStatement selectStatementInUpdateApp=null;
		ResultSet resultSet=null;		
		Scanner scanner=null;
		
		Integer empId=null;
		String empName=null;
		Integer empAge=null;
		String empAddress=null;
		String empNameInput=null;
		Integer empAgeInput=null;
		String empAddressInput=null;
		
		try {
			
			String sqlUpdateQuery="update employeedetails set empname=?, empage=?, empaddress=? where empid=?";
			String sqlSelectQueryInUpdateApp="select empname,empage,empaddress from employeedetails where empid=?";
			
			connection=JDBCUtility.getJdbcConnection();
			if(connection != null) {
				updateStatement=connection.prepareStatement(sqlUpdateQuery);
				selectStatementInUpdateApp=connection.prepareStatement(sqlSelectQueryInUpdateApp);
			}
			
			
			if(updateStatement != null && selectStatementInUpdateApp !=null) {
				scanner=new Scanner(System.in);
				
				System.out.println("Enter the EmpID to update the details");
				empId=scanner.nextInt();
				
				
				if(empId != null) {
					selectStatementInUpdateApp.setInt(1, empId);
					
					//Execute Select Statement for the same empId to collect details
					resultSet=selectStatementInUpdateApp.executeQuery();
					while(resultSet.next()) {
						empName=resultSet.getString(1);
						empAge=resultSet.getInt(2);
						empAddress=resultSet.getString(3);
					}
					
					//Taking user input for update
					System.out.print("Enter the employee name to be updated:: ");
					empNameInput=scanner.next();
					if(empNameInput != "")
						empName=empNameInput;
					
					System.out.println("Enter the employee age to be updated:: ");
					empAgeInput=scanner.nextInt();
					if(empAgeInput != null)
						empAge=empAgeInput;
					
					System.out.println("Enter the employee address to be updated:: ");
					empAddressInput=scanner.next();
					if(empAddressInput != null)
						empAddress=empAddressInput;
					
					//
					updateStatement.setString(1, empName);
					updateStatement.setInt(2, empAge);
					updateStatement.setString(3, empAddress);
					updateStatement.setInt(4, empId);
					
					//Run Update Query
					int rowCount=updateStatement.executeUpdate();
					System.out.println("Row updated successfully");
					System.out.println("Number of rows affected:: "+rowCount);
					
				}
				
			}
		}		
	     catch(SQLException se) {
			System.out.println("SQLException found in Update App");
			se.printStackTrace();
		}catch(Exception e) {
			
			System.out.println("Exception found in Update App");
			e.printStackTrace();
		}finally {
			try {
				System.out.println("Cleaning up the resources");
				JDBCUtility.cleanUp(connection, updateStatement, null);
			}catch(SQLException se) {
				System.out.println("SQLException found in Update App");
				se.printStackTrace();
			}catch(Exception e) {
				
				System.out.println("Exception found in Update App");
				e.printStackTrace();
			}
		}
	}
}
