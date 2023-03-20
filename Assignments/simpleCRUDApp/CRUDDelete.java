package Assignments.simpleCRUDApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDDelete {
	
	
	
	public static void deleteDetails() {
		
		Connection connection=null;
		PreparedStatement deleteStatement=null;
		Scanner scanner=null;
		
		Integer empId=null;
		
		try {
			connection=JDBCUtility.getJdbcConnection();
			String sqlDeleteQuery="delete from employeedetails where empId=?";
			
			if(connection != null)
				deleteStatement=connection.prepareStatement(sqlDeleteQuery);
			
			if(deleteStatement != null) {
				scanner=new Scanner(System.in);
				System.out.println("Enter the EmpId of the employee to be deleted");
				empId=scanner.nextInt();
				
				if(empId != null) {
					deleteStatement.setInt(1, empId);
					
					int rowCount=deleteStatement.executeUpdate();
					System.out.println("Number of rows affected:: "+rowCount);
				}else {
					System.out.println("EmpId can't be null");
				}
			}
				
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBCUtility.cleanUp(connection, deleteStatement, null);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
