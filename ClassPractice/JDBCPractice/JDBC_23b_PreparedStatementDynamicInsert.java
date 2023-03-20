package ClassPractice.JDBCPractice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_23b_PreparedStatementDynamicInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		Scanner scanner=null;
		
		try {
			
			//Establish the connection
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			//Write the SQL query to be used inside preparedstatement
			String sqlInsertQuery="insert into student(`sname`,`sage`,`saddress`,`sgender`) values(?,?,?,?)";
			
			//Defining Prepared Statement
			if(connection != null) 
				pstmt=connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt != null) {
				scanner = new Scanner(System.in);
				
				//Taking user inputs for the table field values
				System.out.println("Enter the name of the student:: ");
				String sname=scanner.next();
				
				System.out.println("Enter the age of the student:: ");
				int sage=scanner.nextInt();
				
				System.out.println("Enter the address of the student:: ");
				String saddress=scanner.next();
				
				System.out.println("Enter the gender of the student:: ");
				String sgender=scanner.next();
				
				
					
					//Use precompiled query to set the values
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
					pstmt.setString(4, sgender);
					
					//Execute the query
					int rowCount=pstmt.executeUpdate();
					System.out.println("No. of rows updated:: "+rowCount);
					
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				scanner.close();
				JDBC_20_JDBCUtility.cleanUp(connection, null, null);
				System.out.println("Cleaning up the resources");
			}catch(SQLException se) {
				System.out.println("SQL Exception occured while cleaning up the resources");
				se.printStackTrace();
			}catch(Exception e) {
				System.out.println("Exception occured while cleaning up the resources");
				e.printStackTrace();
			}
		}
	}

}
