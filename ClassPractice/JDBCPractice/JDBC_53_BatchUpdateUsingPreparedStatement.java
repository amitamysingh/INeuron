package ClassPractice.JDBCPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_53_BatchUpdateUsingPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
//		String empName;
//		Integer empAge;
//		String empAddress;
		try {
			
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			String sqlInsertQuery = "insert into employeedetails (empname,empage,empaddress) values(?,?,?)";
			
			if(connection != null)
				pstmt=connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt != null) {
				 scanner = new Scanner(System.in);
				 while(true) {
					 System.out.println("Enter the employee name::");
					 String empName=scanner.next();
					 
					 System.out.println("Enter the employee age:: ");
					 Integer empAge=scanner.nextInt();
					 
					 System.out.println("Enter the employee address::");
					 String empAddress=scanner.next();
					 
					 pstmt.setString(1, empName);
					 pstmt.setInt(2, empAge);
					 pstmt.setString(3, empAddress);
					 
					 //Adding a batch for all the queries
					 pstmt.addBatch();
					 
					 System.out.println("Do you want to insert more?[YES/NO]");
					 String option=scanner.next();
					 
					 if(option.equalsIgnoreCase("no")) {
						 break;
					 }
				 }
				 
				 //Executing the queries in batch file
				 pstmt.executeBatch();
				 System.out.println("Records inserted successfully...");
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, null);
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
