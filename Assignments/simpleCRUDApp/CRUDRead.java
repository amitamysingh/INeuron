package Assignments.simpleCRUDApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDRead {
	
	
	
	//
	public static void readDetails() {
		//Resources used
		Connection connection=null;
		PreparedStatement selectStatement=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		
		try {
			connection=JDBCUtility.getJdbcConnection();
			
			//
			String sqlSelectQuery="select empname,empage,empaddress from employeedetails where empid=?";
			if(connection != null)
				selectStatement=connection.prepareStatement(sqlSelectQuery);
			
			if(selectStatement != null) {
				scanner=new Scanner(System.in);
				System.out.print("Enter the employee id:: ");
				Integer empId=scanner.nextInt();
				
				if(empId != null) {
					selectStatement.setInt(1, empId);
					
					resultSet=selectStatement.executeQuery();
					if(resultSet != null) {
						
						System.out.println("EMPNAME\tEMPAGE\tEMPADDRESS");
						
						if(resultSet.next()) {
						System.out.println(resultSet.getString(1)+"\t"
						+resultSet.getInt(2)+"\t"
								+resultSet.getString(3));
						}
					}
				}
			}
		}catch(SQLException se) {
			
			System.out.println("SQL Exception found in Select App");
			se.printStackTrace();
			
		}catch(Exception e) {
			
			System.out.println("Exception found in Select App");
			e.printStackTrace();
			
		}finally {
			try {
				
				System.out.println("Cleaning up resources");
				JDBCUtility.cleanUp(connection, selectStatement, null);
				
			}catch(SQLException se) {
				
				System.out.println("SQL Exception found in Cleaning up select App");
				se.printStackTrace();
				
			}catch(Exception e) {
				
				System.out.println("Exception found in cleaning up Select App");
				e.printStackTrace();
			}
		}
	}
	
}
