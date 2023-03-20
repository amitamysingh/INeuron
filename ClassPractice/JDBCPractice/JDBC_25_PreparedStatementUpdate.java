package ClassPractice.JDBCPractice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_25_PreparedStatementUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement pstmt = null;
		Scanner scanner=null;
		
		try {
			connection=JDBC_20_JDBCUtility.getJdbcConnection();
			
			String sqlUpdateQuery="update student set saddress =? where sid =?";
			if(connection != null)
				pstmt=connection.prepareStatement(sqlUpdateQuery);
			
			if(pstmt != null) {
				
				scanner =new Scanner(System.in);
				
				System.out.println("Enter the sid:: ");
				int sid=scanner.nextInt();
				
				System.out.println("Enter the saddress:: ");
				String saddress=scanner.next();
				
				//Use precompiled query to set the values
				pstmt.setString(1, saddress);
				pstmt.setInt(2, sid);
				
				//Execute the query
				int rowCount=pstmt.executeUpdate();
				System.out.println("No of affected rows:: "+rowCount);
			}
			
		}catch(SQLException se) {
			System.out.println("SQL Exception in coding block");
			se.printStackTrace();
		}catch(IOException ie) {
			System.out.println("IO Exception is coding block");
			ie.printStackTrace();
		}catch(Exception e) {
			System.out.println("Exception in coding block");
			e.printStackTrace();
		}finally {
			try {
				scanner.close();
				JDBC_20_JDBCUtility.cleanUp(connection, pstmt, null);
				System.out.println("Cleaning up the resources");
			}catch(SQLException se) {
				System.out.println("SQL Exception in coding block");
				se.printStackTrace();
			}catch(Exception e) {
				System.out.println("Exception in coding block");
				e.printStackTrace();
			}
		}
	}

}
